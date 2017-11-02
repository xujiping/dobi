package com.xjp.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 认证客户端.
 *
 * @author xujiping 2017-10-24 10:06
 */
@EnableDiscoveryClient
@SpringBootApplication
public class AuthcClientApplication {

  public static void main(String[] args) {
    SpringApplication.run(AuthcClientApplication.class);
  }
}
