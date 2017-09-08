package com.xjp.model;

import javax.persistence.*;

@Table(name = "format")
public class Format {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 格式后缀
     */
    private String format;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取格式后缀
     *
     * @return format - 格式后缀
     */
    public String getFormat() {
        return format;
    }

    /**
     * 设置格式后缀
     *
     * @param format 格式后缀
     */
    public void setFormat(String format) {
        this.format = format;
    }
}