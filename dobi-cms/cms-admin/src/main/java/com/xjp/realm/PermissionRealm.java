package com.xjp.realm;

//import com.xjp.model.Role;
//import com.xjp.model.User;
//import com.xjp.service.UserService;

import com.xjp.dao.UserMapper;
import com.xjp.model.User;
import com.xjp.service.Userservice;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义权限认证
 * Created by xjpdy on 2017/7/31.
 */
@Component
public class PermissionRealm extends AuthorizingRealm {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @Autowired
  private UserMapper userMapper;

  /**
   * 权限认证
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    String username = (String) principals.getPrimaryPrincipal();
//        User user = userService.getUser(username);
    Set<String> permissions = new HashSet<>();
    //用户所属角色
//        Set<String> roles = new HashSet<>();
//        List<Role> roleList = userService.getUserRoles(user);
//        logger.info(this.getClass().getName() + "--用户所有角色：" + roleList);
//        for (Role role : roleList) {
//            roles.add(role.getName());
//        }
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.setStringPermissions(roles);//添加角色集合
    info.setStringPermissions(permissions);  //添加权限集合
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
    logger.info(this.getClass().getName() + "--获取认证的用户名：" + username + " 密码：" + password);
    User instance = new User();
    instance.setUsername(username);
    instance.setPassword(password);
    User user = userMapper.selectOne(instance);
    if (user == null) {
      throw new AccountException("账号或密码不正确");
    } else {
      //登录成功
      Subject subject = SecurityUtils.getSubject();
      Session session = subject.getSession();
      session.setAttribute("user", user);
    }
    return new SimpleAuthenticationInfo(username, password, getName());
  }

  @Override
  public String getName() {
    return "permissionRealm";
  }

  @Override
  public boolean supports(AuthenticationToken token) {
    return token instanceof UsernamePasswordToken;
  }
}
