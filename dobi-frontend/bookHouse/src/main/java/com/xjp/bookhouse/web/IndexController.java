package com.xjp.bookhouse.web;

import com.xjp.bookhouse.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * index.
 *
 * @author xujiping 2017-10-27 16:57
 */
@Controller
public class IndexController {

  @Autowired
  BookService bookService;

  @GetMapping("info")
  @ResponseBody
  public String info() {
    return "服务消费：bookhouse";
  }

  @GetMapping("/book/info")
  @ResponseBody
  public String bookInfo() {
    String info = bookService.bookInfo();
    return "cmdBook返回数据：" + info;
  }

}
