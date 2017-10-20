package com.xjp.authc.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.web.session.mgt.WebSessionContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * session工厂.
 *
 * @author xujiping 2017-10-19 11:23
 */
@Component
public class AuthcServerSessionFactory implements SessionFactory {
  @Override
  public Session createSession(SessionContext sessionContext) {
    AuthcServerSession session = new AuthcServerSession();
    if (null != sessionContext && sessionContext instanceof WebSessionContext) {
      WebSessionContext webSessionContext = (WebSessionContext) sessionContext;
      HttpServletRequest request = (HttpServletRequest) webSessionContext.getServletRequest();
      if (null != request) {
        session.setHost(request.getRemoteAddr());
        session.setUserAgent(request.getHeader("User-Agent"));
      }
    }
    return session;
  }
}
