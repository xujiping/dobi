package com.xjp.model;

import javax.persistence.*;

@Table(name = "role")
public class Role {
    /**
     * 编号
     */
    @Id
    @Column(name = "role_id")
    private Integer roleId;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色标题
     */
    private String title;

    /**
     * 角色描述
     */
    private String description;

    /**
     * 创建时间
     */
    private Long ctime;

    /**
     * 排序
     */
    private Long orders;

    /**
     * 获取编号
     *
     * @return role_id - 编号
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置编号
     *
     * @param roleId 编号
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取角色名称
     *
     * @return name - 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名称
     *
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取角色标题
     *
     * @return title - 角色标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置角色标题
     *
     * @param title 角色标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取角色描述
     *
     * @return description - 角色描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置角色描述
     *
     * @param description 角色描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取创建时间
     *
     * @return ctime - 创建时间
     */
    public Long getCtime() {
        return ctime;
    }

    /**
     * 设置创建时间
     *
     * @param ctime 创建时间
     */
    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    /**
     * 获取排序
     *
     * @return orders - 排序
     */
    public Long getOrders() {
        return orders;
    }

    /**
     * 设置排序
     *
     * @param orders 排序
     */
    public void setOrders(Long orders) {
        this.orders = orders;
    }
}