package com.xjp.model;

import javax.persistence.*;

@Table(name = "user")
public class User {
    /**
     * 编号
     */
    @Id
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 帐号
     */
    private String username;

    /**
     * 密码MD5(密码+盐)
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 姓名
     */
    private String realname;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 电话
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private Byte sex;

    /**
     * 状态(0:正常,1:锁定)
     */
    private Byte locked;

    /**
     * 创建时间
     */
    private Long ctime;

    /**
     * 获取编号
     *
     * @return user_id - 编号
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置编号
     *
     * @param userId 编号
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取帐号
     *
     * @return username - 帐号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置帐号
     *
     * @param username 帐号
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码MD5(密码+盐)
     *
     * @return password - 密码MD5(密码+盐)
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码MD5(密码+盐)
     *
     * @param password 密码MD5(密码+盐)
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取盐
     *
     * @return salt - 盐
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 设置盐
     *
     * @param salt 盐
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 获取姓名
     *
     * @return realname - 姓名
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置姓名
     *
     * @param realname 姓名
     */
    public void setRealname(String realname) {
        this.realname = realname;
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 获取状态(0:正常,1:锁定)
     *
     * @return locked - 状态(0:正常,1:锁定)
     */
    public Byte getLocked() {
        return locked;
    }

    /**
     * 设置状态(0:正常,1:锁定)
     *
     * @param locked 状态(0:正常,1:锁定)
     */
    public void setLocked(Byte locked) {
        this.locked = locked;
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
}