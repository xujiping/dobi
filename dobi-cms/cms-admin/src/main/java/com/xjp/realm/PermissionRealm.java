package com.xjp.realm;

import com.xjp.dao.UserMapper;
import com.xjp.model.Role;
import com.xjp.model.User;
import com.xjp.service.RoleService;
import com.xjp.util.MD5Util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

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


/**
 * 自定义权限认证
 * Created by xjpdy on 2017/7/31.
 */
@Component
public class PermissionRealm extends AuthorizingRealm {

  private Logger logger = LoggerFactory.getLogger(getClass());

  private UserMapper userMapper;

  private RoleService roleService;

  @SuppressWarnings("SpringJavaAutowiringInspection")
  @Resource
  public void setUserMapper(UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  @SuppressWarnings("SpringJavaAutowiringInspection")
  @Resource
  public void setRoleService(RoleService roleService) {
    this.roleService = roleService;
  }

  /**
   * 权限认证.
   */
  @Override
  protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
    SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
    String username = (String) principals.getPrimaryPrincipal();
    User record = new User();
    record.setUsername(username);
    User user = userMapper.selectOne(record);
    Set<String> permissions = new HashSet<>();
    // TODO 用户权限实现
    info.setStringPermissions(permissions);  //添加权限集合
    //用户所属角色
    Set<String> roles = new HashSet<>();
    List<Role> roleList = roleService.selectUserRoles(user);
    logger.info(this.getClass().getName() + "--用户所有角色：" + roleList);
    if (roleList != null && roleList.size() > 0){
      for (Role role : roleList) {
        roles.add(role.getName());
      }
    }
    info.setStringPermissions(roles);//添加角色集合
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
    User user = userMapper.selectOne(instance);
    if (user == null) {
      throw new AccountException("该账号不存在");
    }
    if (!user.getPassword().equals(MD5Util.MD5(password + user.getSalt()))) {
      throw new IncorrectCredentialsException("账号或密码不正确");
    }
    //登录成功
    Subject subject = SecurityUtils.getSubject();
    Session session = subject.getSession();
    session.setAttribute("user", user);
    return new SimpleAuthenticationInfo(username, password, getName());
  }

  @Override
  public String getName() {
    return "permissionRealm";
  }

  @Override
  public boolean supports(AuthenticationToken token) {
    //仅支持UsernamePasswordToken类型的token
    return token instanceof UsernamePasswordToken;
  }
}
