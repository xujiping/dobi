package com.xjp.bookhouse.web;

import com.xjp.bookhouse.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * index.
 *
 * @author xujiping 2017-10-27 16:57
 */
@Controller
@RefreshScope  //会在配置更改时得到特殊的处理
public class IndexController {

  @Autowired
  BookService bookService;

  @Value("${profile}")
  private String profile;

  @GetMapping("/profile")
  @ResponseBody
  public String profile(){
    return "从配置中心获取当前profile：" + this.profile;
  }

  @GetMapping("/info")
  @ResponseBody
  public String info() {
    return "bookhouse：服务消费者";
  }

  @GetMapping("/book/info")
  @ResponseBody
  public String bookInfo() {
    String info = bookService.bookInfo();
    return "cmdBook返回数据：" + info;
  }

}
