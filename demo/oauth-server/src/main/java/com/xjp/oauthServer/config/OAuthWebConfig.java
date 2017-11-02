package com.xjp.oauthServer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders
    .AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration
    .WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.sql.DataSource;

/**
 * 配置用户信息，以及受保护路径、允许访问路径.
 *
 * @author xujiping 2017-10-31 17:20
 */
@Configuration
public class OAuthWebConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  private DataSource dataSource;

  @Override
  public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/favor.ico");  //忽略网站图标
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    super.configure(http);
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().dataSource(dataSource);
    UserDetails reader = userDetailsService().loadUserByUsername("reader");
    System.out.println("用户reader的密码：" + reader.getPassword());
  }

}
