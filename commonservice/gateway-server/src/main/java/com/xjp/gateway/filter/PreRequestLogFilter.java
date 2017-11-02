package com.xjp.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义请求前置过滤器.
 *
 * @author xujiping 2017-10-26 17:45
 */

public class PreRequestLogFilter extends ZuulFilter {

  private static final Logger _LOGGER = LoggerFactory.getLogger(PreRequestLogFilter.class);

  @Override
  public String filterType() {
    return "pre";
  }

  @Override
  public int filterOrder() {
    return 1;
  }

  @Override
  public boolean shouldFilter() {
    return true;
  }

  @Override
  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();
    _LOGGER.info(String.format("send %s request to %s", request.getMethod(), request.getRequestURL().toString()));
    return null;
  }
}
