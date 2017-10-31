package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration
    .EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration
    .ResourceServerConfigurerAdapter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 认证服务器.
 *
 * @author xujiping 2017-10-30 15:12
 */

@SpringBootApplication
@RestController
@EnableAuthorizationServer
public class SocialApplication {

  @RequestMapping({"/user", "/me"})
  public Map<String, String> user(Principal principal) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("name", principal.getName());
    return map;
  }

  @RequestMapping("/hello")
  public String Hello() {
    return "hello word!";
  }

  @Configuration
  @EnableResourceServer
  protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
      http.antMatcher("/user").authorizeRequests().anyRequest().authenticated();
    }
  }

  public static void main(String[] args) {
    SpringApplication.run(SocialApplication.class);
  }

}
