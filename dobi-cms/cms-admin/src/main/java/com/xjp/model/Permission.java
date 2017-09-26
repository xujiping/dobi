package com.xjp.model;

import javax.persistence.*;

@Table(name = "permission")
public class Permission {
  /**
   * 编号
   */
  @Id
  @Column(name = "permission_id")
  private Integer permissionId;

  /**
   * 所属系统
   */
  @Column(name = "system_id")
  private Integer systemId;

  /**
   * 所属上级
   */
  private Integer pid;

  /**
   * 名称
   */
  private String name;

  /**
   * 类型(1:目录,2:菜单,3:按钮)
   */
  private Byte type;

  /**
   * 权限值
   */
  @Column(name = "permission_value")
  private String permissionValue;

  /**
   * 路径
   */
  private String uri;

  /**
   * 图标
   */
  private String icon;

  /**
   * 状态(0:禁止,1:正常)
   */
  private Byte status;

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
   * @return permission_id - 编号
   */
  public Integer getPermissionId() {
    return permissionId;
  }

  /**
   * 设置编号
   *
   * @param permissionId 编号
   */
  public void setPermissionId(Integer permissionId) {
    this.permissionId = permissionId;
  }

  /**
   * 获取所属系统
   *
   * @return system_id - 所属系统
   */
  public Integer getSystemId() {
    return systemId;
  }

  /**
   * 设置所属系统
   *
   * @param systemId 所属系统
   */
  public void setSystemId(Integer systemId) {
    this.systemId = systemId;
  }

  /**
   * 获取所属上级
   *
   * @return pid - 所属上级
   */
  public Integer getPid() {
    return pid;
  }

  /**
   * 设置所属上级
   *
   * @param pid 所属上级
   */
  public void setPid(Integer pid) {
    this.pid = pid;
  }

  /**
   * 获取名称
   *
   * @return name - 名称
   */
  public String getName() {
    return name;
  }

  /**
   * 设置名称
   *
   * @param name 名称
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * 获取类型(1:目录,2:菜单,3:按钮)
   *
   * @return type - 类型(1:目录,2:菜单,3:按钮)
   */
  public Byte getType() {
    return type;
  }

  /**
   * 设置类型(1:目录,2:菜单,3:按钮)
   *
   * @param type 类型(1:目录,2:菜单,3:按钮)
   */
  public void setType(Byte type) {
    this.type = type;
  }

  /**
   * 获取权限值
   *
   * @return permission_value - 权限值
   */
  public String getPermissionValue() {
    return permissionValue;
  }

  /**
   * 设置权限值
   *
   * @param permissionValue 权限值
   */
  public void setPermissionValue(String permissionValue) {
    this.permissionValue = permissionValue;
  }

  /**
   * 获取路径
   *
   * @return uri - 路径
   */
  public String getUri() {
    return uri;
  }

  /**
   * 设置路径
   *
   * @param uri 路径
   */
  public void setUri(String uri) {
    this.uri = uri;
  }

  /**
   * 获取图标
   *
   * @return icon - 图标
   */
  public String getIcon() {
    return icon;
  }

  /**
   * 设置图标
   *
   * @param icon 图标
   */
  public void setIcon(String icon) {
    this.icon = icon;
  }

  /**
   * 获取状态(0:禁止,1:正常)
   *
   * @return status - 状态(0:禁止,1:正常)
   */
  public Byte getStatus() {
    return status;
  }

  /**
   * 设置状态(0:禁止,1:正常)
   *
   * @param status 状态(0:禁止,1:正常)
   */
  public void setStatus(Byte status) {
    this.status = status;
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