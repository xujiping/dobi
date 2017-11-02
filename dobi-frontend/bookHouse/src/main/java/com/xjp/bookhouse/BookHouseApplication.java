package com.xjp.bookhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * main.
 *
 * @author xujiping 2017-10-27 16:58
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BookHouseApplication {

  public static void main(String[] args) {
    SpringApplication.run(BookHouseApplication.class);
  }
}
