package com.xjp.model;

import javax.persistence.*;

@Table(name = "log")
public class Log {
    /**
     * 编号
     */
    @Id
    @Column(name = "log_id")
    private Integer logId;

    /**
     * 操作描述
     */
    private String description;

    /**
     * 操作用户
     */
    private String username;

    /**
     * 操作时间
     */
    @Column(name = "start_time")
    private Long startTime;

    /**
     * 消耗时间
     */
    @Column(name = "spend_time")
    private Integer spendTime;

    /**
     * 根路径
     */
    @Column(name = "base_path")
    private String basePath;

    /**
     * URI
     */
    private String uri;

    /**
     * URL
     */
    private String url;

    /**
     * 请求类型
     */
    private String method;

    /**
     * 用户标识
     */
    @Column(name = "user_agent")
    private String userAgent;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 权限值
     */
    private String permissions;

    private String parameter;

    private String result;

    /**
     * 获取编号
     *
     * @return log_id - 编号
     */
    public Integer getLogId() {
        return logId;
    }

    /**
     * 设置编号
     *
     * @param logId 编号
     */
    public void setLogId(Integer logId) {
        this.logId = logId;
    }

    /**
     * 获取操作描述
     *
     * @return description - 操作描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置操作描述
     *
     * @param description 操作描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取操作用户
     *
     * @return username - 操作用户
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置操作用户
     *
     * @param username 操作用户
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取操作时间
     *
     * @return start_time - 操作时间
     */
    public Long getStartTime() {
        return startTime;
    }

    /**
     * 设置操作时间
     *
     * @param startTime 操作时间
     */
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取消耗时间
     *
     * @return spend_time - 消耗时间
     */
    public Integer getSpendTime() {
        return spendTime;
    }

    /**
     * 设置消耗时间
     *
     * @param spendTime 消耗时间
     */
    public void setSpendTime(Integer spendTime) {
        this.spendTime = spendTime;
    }

    /**
     * 获取根路径
     *
     * @return base_path - 根路径
     */
    public String getBasePath() {
        return basePath;
    }

    /**
     * 设置根路径
     *
     * @param basePath 根路径
     */
    public void setBasePath(String basePath) {
        this.basePath = basePath;
    }

    /**
     * 获取URI
     *
     * @return uri - URI
     */
    public String getUri() {
        return uri;
    }

    /**
     * 设置URI
     *
     * @param uri URI
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * 获取URL
     *
     * @return url - URL
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置URL
     *
     * @param url URL
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取请求类型
     *
     * @return method - 请求类型
     */
    public String getMethod() {
        return method;
    }

    /**
     * 设置请求类型
     *
     * @param method 请求类型
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 获取用户标识
     *
     * @return user_agent - 用户标识
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * 设置用户标识
     *
     * @param userAgent 用户标识
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    /**
     * 获取IP地址
     *
     * @return ip - IP地址
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置IP地址
     *
     * @param ip IP地址
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取权限值
     *
     * @return permissions - 权限值
     */
    public String getPermissions() {
        return permissions;
    }

    /**
     * 设置权限值
     *
     * @param permissions 权限值
     */
    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }

    /**
     * @return parameter
     */
    public String getParameter() {
        return parameter;
    }

    /**
     * @param parameter
     */
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    /**
     * @return result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result
     */
    public void setResult(String result) {
        this.result = result;
    }
}