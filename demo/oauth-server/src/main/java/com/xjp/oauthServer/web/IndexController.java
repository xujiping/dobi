package com.xjp.oauthServer.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ${DESCRIPTION}
 *
 * @author xujiping 2017-10-31 17:56
 */
@RestController
public class IndexController {

  @GetMapping("/hello")
  public String hello(){
    return "hello";
  }

}
