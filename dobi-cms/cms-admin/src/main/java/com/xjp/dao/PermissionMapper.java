package com.xjp.dao;

import com.xjp.model.Permission;

import java.util.List;
import java.util.Map;

import tk.mybatis.mapper.common.Mapper;

public interface PermissionMapper extends Mapper<Permission> {

  /**
   * 根据role_id查询角色拥有的权限
   * @param roleId
   * @return
   */
  public List<Map<String, Object>> selectByRoleId(int roleId);

}