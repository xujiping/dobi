package com.xjp.web;

import com.xjp.common.Constants;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * login controller.
 *
 * @author xujiping 2017-09-19 15:00
 */

@Controller
@RequestMapping("/login")
public class LoginController {


  @Autowired
  private SecurityManager securityManager;

  @RequestMapping(value = "", method = RequestMethod.GET)
  public String login() {
    return "login";
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
      map.put("code", Constants.SUCCESS);
      map.put("data", "/index");
    } catch (Exception e) {
      e.printStackTrace();
      map.put("code", Constants.ERROR);
      map.put("data", e.getMessage());
    }
    return map;
  }
}
