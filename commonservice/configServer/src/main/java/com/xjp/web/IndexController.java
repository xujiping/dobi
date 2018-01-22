package com.xjp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * index
 *
 * @author xujiping 2017-11-02 14:34
 */
@Controller
public class IndexController {

  @GetMapping("/")
  public String index(){
    return "index";
  }

  @GetMapping("/info")
  @ResponseBody
  public String info(){
    return "config-server：配置中心";
  }
}
