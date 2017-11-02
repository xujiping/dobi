package com.xjp.oauthServer.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Map;

/**
 * 自定义的认证错误页
 *
 * @author xujiping 2017-10-31 17:52
 */
@Controller
@SessionAttributes("authorizationRequest")
public class ErrorController {

  private static final Logger _LOGGER = LoggerFactory.getLogger(ErrorController.class);

  @GetMapping("/oauth/error")
  public String error(@RequestParam Map<String, String> parameters) {
    String uri = parameters.get("redirect_uri");
    _LOGGER.info("重定向：{}", uri);
    return "redirect:" + uri + "?error=1";
  }

}
