package com.xjp.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * index
 *
 * @author xujiping 2017-10-27 11:26
 */
@Controller
public class IndexController {

  @Autowired
  private DiscoveryClient discoveryClient;

  @GetMapping("info")
  @ResponseBody
  public String info() {
    return "cmsBook：书籍微服务提供者";
  }

  @GetMapping("/")
  @ResponseBody
  public String index(HttpServletRequest request) {
    System.out.println("远程地址：" + request.getRemoteAddr());
    Cookie[] cookies = request.getCookies();
    return "cmsBook";
  }

  @GetMapping("/index")
  public String uploadPage() {
    return "index";
  }

  /**
   * 文件上传
   */
  @PostMapping("/upload")
  @ResponseBody
  public String handleFileUpload(@RequestParam(value = "file", required = true) MultipartFile
                                       file) throws IOException {
    byte[] bytes = file.getBytes();
    File file1 = new File(file.getOriginalFilename());
    FileCopyUtils.copy(bytes, file1);
    return file1.getAbsolutePath();
  }

  /**
   * 打印服务实例的相关内容
   * @return
   */
  @GetMapping("/dc")
  @ResponseBody
  public String dc(){
    String services = "Services:" + discoveryClient.getServices();
    System.out.println(services);
    return services;
  }

}
