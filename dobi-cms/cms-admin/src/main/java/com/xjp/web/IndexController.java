package com.xjp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * index.
 *
 * @author xujiping 2017-09-19 15:05
 */

@Controller
public class IndexController {

  /**
   * index.
   *
   * @return index.html
   */
  @RequestMapping(value = {"", "/index"})
  public String index() {
    return "index";
  }
}
