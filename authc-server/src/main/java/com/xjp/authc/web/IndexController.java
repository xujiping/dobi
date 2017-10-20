package com.xjp.authc.web;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * ${DESCRIPTION}
 *
 * @author xujiping 2017-10-18 15:10
 */

@Controller
public class IndexController {

  @Autowired
  private SecurityManager securityManager;

  @RequestMapping("/index")
  @ResponseBody
  public String index() {
    return "login success";
  }

  @RequestMapping("/login")
  public String login() {
    return "login";
  }

  @RequestMapping("/403")
  @ResponseBody
  public String fail() {
    return "error";
  }

  /**
   * 登录.
   *
   * @param username 用户名
   * @param password 密码
   * @return Map
   */
  @RequestMapping(value = "/ajaxLogin", method = RequestMethod.POST)
  @ResponseBody
  public Map<String, Object> doLogin(String username, String password, boolean rememberMe, String
      backurl) {
    LinkedHashMap<String, Object> map = new LinkedHashMap<>();
    try {
      //使用用户登录信息创建令牌
      UsernamePasswordToken token = new UsernamePasswordToken(username, password);
      //执行登陆动作
      SecurityUtils.setSecurityManager(securityManager);
      SecurityUtils.getSubject().login(token);
      map.put("code", "1");
      map.put("data", "/index");
    } catch (Exception e) {
      e.printStackTrace();
      map.put("code", "0");
      map.put("data", e.getMessage());
    }
    return map;
  }

}
