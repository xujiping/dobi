package com.xjp.service;

import com.xjp.common.service.BaseService;
import com.xjp.model.Role;
import com.xjp.model.User;

import java.sql.SQLException;
import java.util.List;

/**
 * role service.
 *
 * @author xujiping 2017-09-20 10:24
 */
public interface RoleService extends BaseService<Role, Role> {

  /**
   * 查询用户所属角色列表
   * @param user User
   * @return List
   */
  public List<Role> selectUserRoles(User user);

  public int deleteByPrimaryKeys(String[] ids) throws SQLException;

}
