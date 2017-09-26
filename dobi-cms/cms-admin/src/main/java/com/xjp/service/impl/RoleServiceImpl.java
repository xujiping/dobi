package com.xjp.service.impl;

import com.xjp.annotation.BaseService;
import com.xjp.common.service.BaseServiceImpl;
import com.xjp.dao.RoleMapper;
import com.xjp.model.Role;
import com.xjp.model.User;
import com.xjp.service.RoleService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

/**
 * role serviceimpl.
 *
 * @author xujiping 2017-09-20 10:26
 */
@Service
@Transactional
@BaseService
public class RoleServiceImpl extends BaseServiceImpl<RoleMapper, Role, Role> implements
    RoleService {

  private static Logger _log = LoggerFactory.getLogger(RoleServiceImpl.class);

  RoleMapper roleMapper;

  @SuppressWarnings("SpringJavaAutowiringInspection")
  @Resource
  public void setRoleMapper(RoleMapper roleMapper) {
    this.roleMapper = roleMapper;
  }

  @Override
  public List<Role> selectUserRoles(User user) {
    // TODO  getUserRoles实现
    return null;
  }

  @Override
  public int deleteByPrimaryKeys(String[] ids) throws SQLException {
    for (String id :
        ids) {
      int i = roleMapper.deleteByPrimaryKey(Integer.parseInt(id));
      if (i == 0) {
        throw new SQLException("删除角色失败：id=" + id);
      }
    }
    return 1;
  }

}
