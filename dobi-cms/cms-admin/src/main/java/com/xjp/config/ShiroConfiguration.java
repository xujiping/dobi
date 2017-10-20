package com.xjp.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 权限配置
 * Created by xjpdy on 2017/7/31.
 */
@Configuration
public class ShiroConfiguration {

  @Autowired
  private Realm permissionRealm;

  @Bean
  public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
    ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
    //必须设置SecurityManager
    shiroFilterFactoryBean.setSecurityManager(securityManager);
    //如果不设置默认会自动寻找根目录/login.jsp页面
    shiroFilterFactoryBean.setLoginUrl("/login");
    //登录成功后跳转
    shiroFilterFactoryBean.setSuccessUrl("/index");
    //未授权界面
    shiroFilterFactoryBean.setUnauthorizedUrl("/403");
    //设置拦截器
    Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
    //配置不会被拦截的链接，顺序判断
    filterChainDefinitionMap.put("/static/**", "anon");
    filterChainDefinitionMap.put("/css/**", "anon");
    filterChainDefinitionMap.put("/js/**", "anon");
    filterChainDefinitionMap.put("/login/ajaxLogin", "anon");
    filterChainDefinitionMap.put("/plugins/**", "anon");
    //增加以下配置，防止shiro阻拦swagger2的请求
    filterChainDefinitionMap.put("/webjars/**", "anon");
    filterChainDefinitionMap.put("/swagger-resources/**", "anon");
    filterChainDefinitionMap.put("/v2/api-docs", "anon");
    filterChainDefinitionMap.put("/swagger-ui.html**", "anon");
//    filterChainDefinitionMap.put("/cmsBook/**", "anon");
    //配置退出过滤器，具体代码Shiro已经是实现
    filterChainDefinitionMap.put("/logout", "logout");
    filterChainDefinitionMap.put("/add", "perms[权限添加]");
    // <!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
    // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
    filterChainDefinitionMap.put("/**", "authc");
    // filterChainDefinitionMap.put("/**", "anon");
    shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    System.out.println("Shiro拦截器工厂类注入成功");
    return shiroFilterFactoryBean;
  }

  @Bean
  public SecurityManager securityManager() {
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    //设置realm
    securityManager.setRealm(permissionRealm);
    return securityManager;
  }

//  @Bean(name = "lifecycleBeanPostProcessor")
//  public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
//    return new LifecycleBeanPostProcessor();
//  }

  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager
                                                                                     securityManager) {
    AuthorizationAttributeSourceAdvisor advisor = new
        AuthorizationAttributeSourceAdvisor();
    advisor.setSecurityManager(securityManager);
    return advisor;
  }
}
