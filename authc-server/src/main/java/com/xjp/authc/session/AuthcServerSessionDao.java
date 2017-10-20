package com.xjp.authc.session;

import com.xjp.authc.util.RedisUtil;
import com.xjp.authc.util.SerializableUtil;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Set;

import redis.clients.jedis.Jedis;

/**
 * 基于redis的sessionDao，缓存共享session.
 *
 * @author xujiping 2017-10-19 10:21
 */
@Component
public class AuthcServerSessionDao extends CachingSessionDAO {

  private static Logger _LOGGER = LoggerFactory.getLogger(AuthcServerSessionDao.class);

  //会话key
  private final static String AUTHC_SERVER_SHIRO_SESSION_ID = "authc-server-shiro-session-id";

  //全局会话key
  private final static String AUTHC_SERVER_GLOBAL_SESSION_ID = "authc-server-global-session-id";

  //全局会话列表key
  private final static String AUTHC_SERVER_GLOBAL_SESSION_IDS = "authc-server-golbal-session-ids";

  // code key
  private final static String AUTHC_SERVER__CODE = "authc-server-code";

  // 局部会话key
  private final static String AUTHC_CLIENT_SESSION_ID = "authc-client-session-id";

  // 单点同一个code所有局部会话key
  private final static String AUTHC_CLIENT_SESSION_IDS = "authc-client-session-ids";

  @Autowired
  private RedisUtil RedisUtil;

  @Override
  protected void doUpdate(Session session) {
    // 如果会话过期/停止 没必要再更新了
    if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
      return;
    }
    AuthcServerSession authcServerSession = (AuthcServerSession) session;
    AuthcServerSession cacheSession = (AuthcServerSession) doReadSession(session.getId());
    if (cacheSession != null){
      authcServerSession.setStatus(cacheSession.getStatus());
      authcServerSession.setAttribute("FORCE_LOGOUT", cacheSession.getAttribute("FORCE_LOGOUT"));
    }
    RedisUtil.set(AUTHC_SERVER_SHIRO_SESSION_ID + "_" + session.getId(), SerializableUtil.serialize(session), (int) session.getTimeout() / 1000);
    _LOGGER.debug("doUpdate >>>>> sessionId={}", session.getId());

  }

  @Override
  protected void doDelete(Session session) {
    String sessionId = session.getId().toString();
    // 当前全局会话code
    String code = RedisUtil.get(AUTHC_SERVER_GLOBAL_SESSION_ID + "_" + sessionId);
    // 清除全局会话
    RedisUtil.remove(AUTHC_SERVER_GLOBAL_SESSION_ID + "_" + sessionId);
    // 清除code校验值
    RedisUtil.remove(AUTHC_SERVER__CODE + "_" + code);
    // 清除所有局部会话
    Jedis jedis = RedisUtil.getJedis();
    Set<String> clientSessionIds = jedis.smembers(AUTHC_CLIENT_SESSION_IDS + "_" + code);
    for (String clientSessionId : clientSessionIds) {
      jedis.del(AUTHC_CLIENT_SESSION_ID + "_" + clientSessionId);
      jedis.srem(AUTHC_CLIENT_SESSION_IDS + "_" + code, clientSessionId);
    }
    _LOGGER.debug("当前code={}，对应的注册系统个数：{}个", code, jedis.scard(AUTHC_CLIENT_SESSION_IDS + "_" + code));
    jedis.close();
    // 维护会话id列表，提供会话分页管理
    RedisUtil.lrem(AUTHC_SERVER_GLOBAL_SESSION_IDS, 1, sessionId);
    // 删除session
    RedisUtil.remove(AUTHC_SERVER_SHIRO_SESSION_ID + "_" + sessionId);
    _LOGGER.debug("doUpdate >>>>> sessionId={}", sessionId);
  }

  @Override
  protected Serializable doCreate(Session session) {
    Serializable sessionId = generateSessionId(session);
    assignSessionId(session, sessionId);
    RedisUtil.set(AUTHC_SERVER_SHIRO_SESSION_ID + "_" + sessionId, SerializableUtil.serialize
        (session), (int) session.getTimeout() / 1000);
    _LOGGER.debug("doCreate >>>>> sessionId={}", sessionId);
    return sessionId;
  }

  @Override
  protected Session doReadSession(Serializable sessionId) {
    String session = RedisUtil.get(AUTHC_SERVER_SHIRO_SESSION_ID + "_" + sessionId);
    _LOGGER.debug("doReadSession >>>>> sessionId={}", sessionId);
    //反序列化并返回
    return SerializableUtil.deserialize(session);
  }

  /**
   * 强制退出
   * @param ids
   * @return
   */
  public int forceout(String ids) {
    String[] sessionIds = ids.split(",");
    for (String sessionId : sessionIds) {
      // 会话增加强制退出属性标识，当此会话访问系统时，判断有该标识，则退出登录
      String session = RedisUtil.get(AUTHC_SERVER_SHIRO_SESSION_ID + "_" + sessionId);
      AuthcServerSession upmsSession = (AuthcServerSession) SerializableUtil.deserialize(session);
      upmsSession.setStatus(AuthcServerSession.OnlineStatus.force_logout);
      upmsSession.setAttribute("FORCE_LOGOUT", "FORCE_LOGOUT");
      RedisUtil.set(AUTHC_SERVER_SHIRO_SESSION_ID + "_" + sessionId, SerializableUtil.serialize(upmsSession), (int) upmsSession.getTimeout() / 1000);
    }
    return sessionIds.length;
  }
}
