package com.xjp.client.filter;

import com.alibaba.fastjson.JSONObject;
import com.xjp.client.util.PropertiesFileUtil;
import com.xjp.client.util.RedisUtil;
import com.xjp.client.util.RequestParameterUtil;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import redis.clients.jedis.Jedis;

/**
 * 重写authc过滤器.
 *
 * @author xujiping 2017-10-18 15:05
 */

@Component
public class MyAuthenticationFilter extends AuthenticationFilter {

  private final static Logger _LOGGER = LoggerFactory.getLogger(MyAuthenticationFilter.class);

  // 局部会话key
  private final static String AUTHC_CLIENT_SESSION_ID = "authc-client-session-id";

  // 单点同一个code所有局部会话key
  private final static String AUTHC_CLIENT_SESSION_IDS = "authc-client-session-ids";

  @Autowired
  private RedisUtil RedisUtil;

  @Override
  protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object
      mappedValue) {
    Subject subject = getSubject(request, response);
    Session session = subject.getSession();
    return validateClient(request, response);
  }

  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws
      Exception {
    // TODO 跳转当前系统登录页面
//    WebUtils.toHttp(response).sendRedirect("http://localhost:1002/login");
    return false;
  }

  /**
   * 认证中心登录成功带回code
   * @param request
   */
  private boolean validateClient(ServletRequest request, ServletResponse response) {
    Subject subject = getSubject(request, response);
    Session session = subject.getSession();
    String sessionId = session.getId().toString();
    int timeOut = (int) session.getTimeout() / 1000;
    // 判断局部会话是否登录
    String cacheClientSession = RedisUtil.get(AUTHC_CLIENT_SESSION_ID + "_" + session.getId());
    if (StringUtils.isNotBlank(cacheClientSession)) {
      // 更新code有效期
      RedisUtil.set(AUTHC_CLIENT_SESSION_ID + "_" + sessionId, cacheClientSession, timeOut);
      Jedis jedis = RedisUtil.getJedis();
      jedis.expire(AUTHC_CLIENT_SESSION_IDS + "_" + cacheClientSession, timeOut);
      jedis.close();
      // 移除url中的code参数
      if (null != request.getParameter("code")) {
        String backUrl = RequestParameterUtil.getParameterWithOutCode(WebUtils.toHttp(request));
        HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
        try {
          httpServletResponse.sendRedirect(backUrl.toString());
        } catch (IOException e) {
          _LOGGER.error("局部会话已登录，移除code参数跳转出错：", e);
        }
      } else {
        return true;
      }
    }
    // 判断是否有认证中心code
    String code = request.getParameter("upms_code");
    // 已拿到code
    if (StringUtils.isNotBlank(code)) {
      // HttpPost去校验code
      try {
        StringBuffer sso_server_url = new StringBuffer(PropertiesFileUtil.getInstance("zheng-upms-client").get("zheng.upms.sso.server.url"));
        HttpClient httpclient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(sso_server_url.toString() + "/sso/code");

        List<NameValuePair> nameValuePairs = new ArrayList<>();
        nameValuePairs.add(new BasicNameValuePair("code", code));
        httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

        HttpResponse httpResponse = httpclient.execute(httpPost);
        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
          HttpEntity httpEntity = httpResponse.getEntity();
          JSONObject result = JSONObject.parseObject(EntityUtils.toString(httpEntity));
          if (1 == result.getIntValue("code") && result.getString("data").equals(code)) {
            // code校验正确，创建局部会话
            RedisUtil.set(AUTHC_CLIENT_SESSION_ID + "_" + sessionId, code, timeOut);
            // 保存code对应的局部会话sessionId，方便退出操作
            RedisUtil.sadd(AUTHC_CLIENT_SESSION_IDS + "_" + code, sessionId, timeOut);
            _LOGGER.debug("当前code={}，对应的注册系统个数：{}个", code, RedisUtil.getJedis().scard(AUTHC_CLIENT_SESSION_IDS + "_" + code));
            // 移除url中的token参数
            String backUrl = RequestParameterUtil.getParameterWithOutCode(WebUtils.toHttp(request));
            // 返回请求资源
            try {
              // client无密认证
              String username = request.getParameter("upms_username");
              subject.login(new UsernamePasswordToken(username, ""));
              HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
              httpServletResponse.sendRedirect(backUrl.toString());
              return true;
            } catch (IOException e) {
              _LOGGER.error("已拿到code，移除code参数跳转出错：", e);
            }
          } else {
            _LOGGER.warn(result.getString("data"));
          }
        }
      } catch (IOException e) {
        _LOGGER.error("验证token失败：", e);
      }
    }
    return false;
  }
}
