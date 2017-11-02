package com.xjp.client.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ${DESCRIPTION}
 *
 * @author xujiping 2017-10-24 10:15
 */
@Controller
public class IndexController {

  @RequestMapping("/test")
  @ResponseBody
  public String index(){
    return "登录成功";
  }
}
