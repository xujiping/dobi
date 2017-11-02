package com.xjp.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 启动类.
 *
 * @author xujiping 2017-10-16 14:39
 */

@EnableEurekaClient
@SpringBootApplication
public class CmsBookApplication {

  public static void main(String[] args) {
    SpringApplication.run(CmsBookApplication.class, args);
  }

}
