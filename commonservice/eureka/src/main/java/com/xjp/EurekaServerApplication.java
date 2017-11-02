package com.xjp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Eureka服务注册中心
 *
 * @author xujiping 2017-10-16 15:50
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

  public static void main(String[] args){
    SpringApplication.run(EurekaServerApplication.class, args);
  }
}
