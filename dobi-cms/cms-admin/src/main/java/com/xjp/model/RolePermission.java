package com.xjp.model;

import javax.persistence.*;

@Table(name = "role_permission")
public class RolePermission {
  /**
   * 编号
   */
  @Id
  @Column(name = "role_permission_id")
  private Integer rolePermissionId;

  /**
   * 角色编号
   */
  @Column(name = "role_id")
  private Integer roleId;

  /**
   * 权限编号
   */
  @Column(name = "permission_id")
  private Integer permissionId;

  /**
   * 获取编号
   *
   * @return role_permission_id - 编号
   */
  public Integer getRolePermissionId() {
    return rolePermissionId;
  }

  /**
   * 设置编号
   *
   * @param rolePermissionId 编号
   */
  public void setRolePermissionId(Integer rolePermissionId) {
    this.rolePermissionId = rolePermissionId;
  }

  /**
   * 获取角色编号
   *
   * @return role_id - 角色编号
   */
  public Integer getRoleId() {
    return roleId;
  }

  /**
   * 设置角色编号
   *
   * @param roleId 角色编号
   */
  public void setRoleId(Integer roleId) {
    this.roleId = roleId;
  }

  /**
   * 获取权限编号
   *
   * @return permission_id - 权限编号
   */
  public Integer getPermissionId() {
    return permissionId;
  }

  /**
   * 设置权限编号
   *
   * @param permissionId 权限编号
   */
  public void setPermissionId(Integer permissionId) {
    this.permissionId = permissionId;
  }

  @Override
  public String toString() {
    return "RolePermission{" +
        "rolePermissionId=" + rolePermissionId +
        ", roleId=" + roleId +
        ", permissionId=" + permissionId +
        '}';
  }
}