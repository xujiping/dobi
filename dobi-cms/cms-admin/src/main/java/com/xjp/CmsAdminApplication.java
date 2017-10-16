package com.xjp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 启动类.
 *
 * @author xujiping
 * @create 2017-08-30 17:12
 */
@SpringBootApplication
@EnableTransactionManagement  //开启事务
@EnableAspectJAutoProxy
public class CmsAdminApplication {

  public static void main(String[] args) {
    SpringApplication.run(CmsAdminApplication.class, args);
  }
}
