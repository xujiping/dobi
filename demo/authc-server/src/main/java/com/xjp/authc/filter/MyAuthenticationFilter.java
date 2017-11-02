package com.xjp.authc.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 重写authc过滤器.
 *
 * @author xujiping 2017-10-18 15:05
 */

@Component
public class MyAuthenticationFilter extends AuthenticationFilter {

  private final static Logger _LOGGER = LoggerFactory.getLogger(MyAuthenticationFilter.class);

  @Override
  protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object
      mappedValue) {
    return false;
  }

  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws
      Exception {
    // TODO 跳转当前系统登录页面
//    WebUtils.toHttp(response).sendRedirect("http://localhost:1002/login");
    return false;
  }
}
