package com.xjp.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.xjp.model.User;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义过滤器(权限控制)
 *
 * @author xujiping 2017-10-17 14:35
 */

@Component
public class MyFilter extends ZuulFilter {
  private static Logger _LOGGER = LoggerFactory.getLogger(MyFilter.class);

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 0;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext context = RequestContext.getCurrentContext();
    HttpServletRequest request = context.getRequest();
    _LOGGER.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString
        ()));
    //获取登录用户信息，可实现其他项目的权限控制
    User user = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
    if (user == null) {
      context.setSendZuulResponse(false);
      context.setResponseStatusCode(401);
      try {
        context.getResponse().getWriter().write("token is empty");
      } catch (Exception e) {
        return null;
      }
      _LOGGER.info("ok");
    }
    return "OK";
  }
}
