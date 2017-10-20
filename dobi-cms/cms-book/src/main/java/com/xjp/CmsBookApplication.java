package com.xjp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 启动类.
 *
 * @author xujiping 2017-10-16 14:39
 */

@EnableDiscoveryClient
@EnableFeignClients
@Controller
@SpringBootApplication
public class CmsBookApplication {

  public static void main(String[] args) {
    SpringApplication.run(CmsBookApplication.class, args);
  }

  @RequestMapping("/")
  @ResponseBody
  public String index(HttpServletRequest request){
    System.out.println("远程地址：" + request.getRemoteAddr());
    Cookie[] cookies = request.getCookies();
    return "cmsBook";
  }

}
