package com.xjp.config;

import com.xjp.factory.OnlineSessionFactory;
import com.xjp.listener.MySessionListener;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.EnterpriseCacheSessionDAO;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * 权限配置
 * Created by xjpdy on 2017/7/31.
 */
@Configuration
public class ShiroConfiguration {

    @Autowired
    private Realm permissionRealm;

    @Autowired
    private MySessionListener mySessionListener;

    @Autowired
    private OnlineSessionFactory onlineSessionFactory;

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
    public SecurityManager securityManager(SessionManager sessionManager) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置realm
        securityManager.setRealm(permissionRealm);
        securityManager.setSessionManager(sessionManager);

        EhCacheManager ehCacheManager = new EhCacheManager();
        ehCacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
        securityManager.setCacheManager(ehCacheManager);

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

    /**
     * 会话管理器
     *
     * @return
     */
    @Bean
    public SessionManager sessionManager(SessionDAO sessionDAO) {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        HashSet<SessionListener> listeners = new HashSet<>();
        listeners.add(mySessionListener);
        sessionManager.setSessionFactory(onlineSessionFactory);
        sessionManager.setSessionListeners(listeners);
        sessionManager.setSessionDAO(sessionDAO);
        return sessionManager;
    }

    /**
     * 会话操作类
     *
     * @return
     */
    @Bean
    public SessionDAO sessionDAO() {
        EnterpriseCacheSessionDAO cacheSessionDAO = new EnterpriseCacheSessionDAO();
        cacheSessionDAO.setActiveSessionsCacheName("shiro-activeSessionCache");  //设置缓存名字
        cacheSessionDAO.setSessionIdGenerator(new JavaUuidSessionIdGenerator());  //设置会话ID生成器，使用java.util.UUID生成
        return cacheSessionDAO;
    }

}
