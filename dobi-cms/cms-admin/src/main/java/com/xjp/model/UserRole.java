package com.xjp.model;

import javax.persistence.*;

@Table(name = "user_role")
public class UserRole {
    /**
     * 编号
     */
    @Id
    @Column(name = "user_role_id")
    private Integer userRoleId;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 角色编号
     */
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 获取编号
     *
     * @return user_role_id - 编号
     */
    public Integer getUserRoleId() {
        return userRoleId;
    }

    /**
     * 设置编号
     *
     * @param userRoleId 编号
     */
    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    /**
     * 获取用户编号
     *
     * @return user_id - 用户编号
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户编号
     *
     * @param userId 用户编号
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
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
}