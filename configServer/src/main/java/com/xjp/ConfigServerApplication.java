package com.xjp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 配置中心.
 *
 * @author xujiping 2017-10-16 16:10
 */
@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
public class ConfigServerApplication {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(ConfigServerApplication.class, args);
  }

}
