package com.xjp.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 书籍微服务提供者
 *
 * @author xujiping 2017-10-16 14:39
 */

@EnableDiscoveryClient  //使用该注解注册，切换注册服务端通用。
@SpringBootApplication
public class CmsBookApplication {

  public static void main(String[] args) {
    SpringApplication.run(CmsBookApplication.class, args);
  }

}
