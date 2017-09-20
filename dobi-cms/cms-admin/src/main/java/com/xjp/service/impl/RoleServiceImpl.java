package com.xjp.service.impl;

import com.xjp.common.service.BaseServiceImpl;
import com.xjp.dao.RoleMapper;
import com.xjp.model.Role;
import com.xjp.model.User;
import com.xjp.service.RoleService;

import java.util.List;

/**
 * role serviceimpl.
 *
 * @author xujiping 2017-09-20 10:26
 */
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, Role, Role> implements
    RoleService {

  @Override
  public List<Role> selectUserRoles(User user) {
    // TODO  getUserRoles实现
    return null;
  }

}
