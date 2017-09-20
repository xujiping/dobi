package com.xjp.model;

import javax.persistence.*;

@Table(name = "user_permission")
public class UserPermission {
    /**
     * 编号
     */
    @Id
    @Column(name = "user_permission_id")
    private Integer userPermissionId;

    /**
     * 用户编号
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 权限编号
     */
    @Column(name = "permission_id")
    private Integer permissionId;

    /**
     * 权限类型(-1:减权限,1:增权限)
     */
    private Byte type;

    /**
     * 获取编号
     *
     * @return user_permission_id - 编号
     */
    public Integer getUserPermissionId() {
        return userPermissionId;
    }

    /**
     * 设置编号
     *
     * @param userPermissionId 编号
     */
    public void setUserPermissionId(Integer userPermissionId) {
        this.userPermissionId = userPermissionId;
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

    /**
     * 获取权限类型(-1:减权限,1:增权限)
     *
     * @return type - 权限类型(-1:减权限,1:增权限)
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置权限类型(-1:减权限,1:增权限)
     *
     * @param type 权限类型(-1:减权限,1:增权限)
     */
    public void setType(Byte type) {
        this.type = type;
    }
}