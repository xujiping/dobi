package com.xjp.client.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 自定义缓存监听器.
 *
 * @author xujiping 2017-10-18 16:09
 */
@Component
public class AuthcSessionListener implements SessionListener {

  private static Logger _LOGGER = LoggerFactory.getLogger(AuthcSessionListener.class);

  @Override
  public void onStart(Session session) {
    _LOGGER.info("会话创建：" + session.getId());
  }

  @Override
  public void onStop(Session session) {
    _LOGGER.info("会话停止：" + session.getId());
  }

  @Override
  public void onExpiration(Session session) {
    _LOGGER.info("会话过期：" + session.getId());
  }
}
