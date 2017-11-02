package com.xjp.authc.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * 自定义权限认证.
 *
 * @author xujiping 2017-10-18 14:35
 */
@Component
public class PermissionRealm extends AuthorizingRealm {

  private Logger _LOGGER = LoggerFactory.getLogger(getClass());

  @Override
  public String getName() {
    return "permissionRealm";
  }

  /**
   * 权限认证.
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    String username = (String) principals.getPrimaryPrincipal();
    Set<String> permissions = new HashSet<>();
    permissions.add("authc:index:view");
    info.setStringPermissions(permissions);
    return info;
  }

  /**
   * 登录认证.
   */
  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws
      AuthenticationException {
    String username = (String) token.getPrincipal();
    String password = new String((char[]) token.getCredentials());
    _LOGGER.info(this.getClass().getName() + "--获取认证的用户名：" + username + " 密码：" + password);
    if (!username.equals("admin") || !password.equals("123456")) {
      throw new IncorrectCredentialsException("用户名或密码不正确");
    }
    //登录成功
    Subject subject = SecurityUtils.getSubject();
    Session session = subject.getSession();
    session.setAttribute("user", username);
    return new SimpleAuthenticationInfo(username, password, getName());
  }

  @Override
  public boolean supports(AuthenticationToken token) {
    //仅支持UsernamePasswordToken类型的token
    return token instanceof UsernamePasswordToken;
  }
}
