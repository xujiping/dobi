package com.xjp.authc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 认证服务中心.
 *
 * @author xujiping 2017-10-18 14:28
 */
@EnableEurekaClient
@SpringBootApplication
public class AuthcServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(AuthcServerApplication.class);
  }
}
