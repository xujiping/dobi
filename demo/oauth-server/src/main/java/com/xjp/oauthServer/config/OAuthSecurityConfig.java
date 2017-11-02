package com.xjp.oauthServer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers
    .ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration
    .AuthorizationServerConfigurerAdapter;


import org.springframework.security.oauth2.config.annotation.web.configurers
    .AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers
    .AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

/**
 * 配置client信息，以及源码中自带路径（如/oauth/check_token,默认是关闭的）的设置.
 *
 * @author xujiping 2017-10-31 16:29
 */
@Configuration
public class OAuthSecurityConfig extends AuthorizationServerConfigurerAdapter {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private DataSource dataSource;

  @Bean
  public TokenStore tokenStore() {
    return new JdbcTokenStore(dataSource);
  }

  @Bean
  public ClientDetailsService clientDetailsService(){
    return new JdbcClientDetailsService(dataSource);
  }

  /**
   * 声明授权和token的端点以及token的服务的一些配置信息，比如采用什么存储方式、token的有效期等.
   */
  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints.authenticationManager(authenticationManager);
    //直接注入一个AuthenticationManager，自动开启密码授权类型
    endpoints.tokenStore(tokenStore());
    //配置TokenServices参数
    DefaultTokenServices tokenServices = new DefaultTokenServices();
    tokenServices.setTokenStore(endpoints.getTokenStore());
    tokenServices.setSupportRefreshToken(false);
    tokenServices.setClientDetailsService(endpoints.getClientDetailsService());
    tokenServices.setTokenEnhancer(endpoints.getTokenEnhancer());
    tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.DAYS.toSeconds((30)));  //30天
    endpoints.tokenServices(tokenServices);
  }

  /**
   * client的信息的读取，可以有in-memory、jdbc等多种读取方式。
   * @param clients
   * @throws Exception
   */
  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//    ClientDetailsService clientDetailsService = clientDetailsService();
//    ClientDetails client = clientDetailsService.loadClientByClientId("client");
//    String clientSecret = client.getClientSecret();
//    System.out.println("===============client:" + clientSecret);
    clients.withClientDetails(clientDetailsService());
  }

  /**
   * 声明安全约束，哪些允许访问，哪些不允许访问
   * @param security
   * @throws Exception
   */
  @Override
  public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
    security.checkTokenAccess("permitAll()");
    security.allowFormAuthenticationForClients();
  }
}
