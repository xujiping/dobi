package com.xjp.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "download")
public class Download {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 客户端IP
     */
    private String ip;

    /**
     * 用户ID
     */
    private Long user;

    /**
     * 书籍ID
     */
    private Long book;

    /**
     * 格式
     */
    private Integer format;

    /**
     * 下载时间
     */
    private Date time;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取客户端IP
     *
     * @return ip - 客户端IP
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置客户端IP
     *
     * @param ip 客户端IP
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取用户ID
     *
     * @return user - 用户ID
     */
    public Long getUser() {
        return user;
    }

    /**
     * 设置用户ID
     *
     * @param user 用户ID
     */
    public void setUser(Long user) {
        this.user = user;
    }

    /**
     * 获取书籍ID
     *
     * @return book - 书籍ID
     */
    public Long getBook() {
        return book;
    }

    /**
     * 设置书籍ID
     *
     * @param book 书籍ID
     */
    public void setBook(Long book) {
        this.book = book;
    }

    /**
     * 获取格式
     *
     * @return format - 格式
     */
    public Integer getFormat() {
        return format;
    }

    /**
     * 设置格式
     *
     * @param format 格式
     */
    public void setFormat(Integer format) {
        this.format = format;
    }

    /**
     * 获取下载时间
     *
     * @return time - 下载时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置下载时间
     *
     * @param time 下载时间
     */
    public void setTime(Date time) {
        this.time = time;
    }
}