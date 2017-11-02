package com.xjp.client.config;

import com.xjp.client.listener.AuthcSessionListener;
import com.xjp.client.session.AuthcServerSessionDao;
import com.xjp.client.session.AuthcServerSessionFactory;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro配置.
 *
 * @author xujiping 2017-10-18 14:34
 */
@Configuration
public class ShiroConfiguration {

  @Autowired
  private Realm permissionRealm;

  @Autowired
  private AuthenticationFilter myAuthenticationFilter;

  @Autowired
  private AuthcServerSessionDao sessionDao;

  @Autowired
  private AuthcSessionListener authcSessionListener;

  @Autowired
  private AuthcServerSessionFactory authcServerSessionFactory;

  @Bean
  public DefaultWebSecurityManager securityManager() {
    DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
    //设置realm
    securityManager.setRealm(permissionRealm);
    //设置会话管理器
    securityManager.setSessionManager(sessionManager(sessionDao));
    return securityManager;
  }

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
    //自定义Filter
    //    Map<String, Filter> filters = new HashMap<>();
    //    filters.put("authc", myAuthenticationFilter);
    //    shiroFilterFactoryBean.setFilters(filters);
    //设置拦截器
    Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
    filterChainDefinitionMap.put("/css/**", "anon");
    filterChainDefinitionMap.put("/js/**", "anon");
    filterChainDefinitionMap.put("/login/ajaxLogin", "anon");
    filterChainDefinitionMap.put("/plugins/**", "anon");
    filterChainDefinitionMap.put("/ajaxLogin", "anon");
    //配置退出过滤器，具体代码Shiro已经是实现
    filterChainDefinitionMap.put("/logout", "logout");
    // <!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
    // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
    filterChainDefinitionMap.put("/**", "authc");
    shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
    System.out.println("Shiro拦截器工厂类注入成功");
    return shiroFilterFactoryBean;
  }

  /**
   * 会话Cookie模板.
   */
  @Bean
  public SimpleCookie sessionIdCookie() {
    SimpleCookie cookie = new SimpleCookie();
    //不会暴露给客户端
    cookie.setHttpOnly(true);
    //设置Cookie的过期时间，秒为单位，默认-1表示关闭浏览器时过期Cookie
    cookie.setMaxAge(-1);
    cookie.setName("authc-server-shiro-session-id");
    return cookie;
  }

  /**
   * 会话管理器.
   */
  @Bean
  public SessionManager sessionManager(AuthcServerSessionDao sessionDao) {
    DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
    //全局session超时时间
    sessionManager.setGlobalSessionTimeout(1800000);
    sessionManager.setSessionDAO(sessionDao);
    sessionManager.setSessionIdCookieEnabled(true);
    sessionManager.setSessionIdCookie(sessionIdCookie());
    sessionManager.setSessionValidationSchedulerEnabled(false);
    Collection<SessionListener> listeners = new ArrayList<>();
    listeners.add(authcSessionListener);
    sessionManager.setSessionListeners(listeners);
    sessionManager.setSessionFactory(authcServerSessionFactory);
    return sessionManager;
  }

  /**
   * 开启Shiro Spring AOP权限注解@RequiresPermissions的支持.
   */
  @Bean
  public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager
                                                                                     securityManager) {
    AuthorizationAttributeSourceAdvisor advisor = new
        AuthorizationAttributeSourceAdvisor();
    advisor.setSecurityManager(securityManager);
    return advisor;
  }

}
