package com.xjp.model;

import javax.persistence.*;

@Table(name = "book_format")
public class BookFormat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 书籍id
     */
    private Long book;

    /**
     * 格式ID
     */
    private Integer format;

    /**
     * 文件大小
     */
    private Long size;

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
     * 获取书籍id
     *
     * @return book - 书籍id
     */
    public Long getBook() {
        return book;
    }

    /**
     * 设置书籍id
     *
     * @param book 书籍id
     */
    public void setBook(Long book) {
        this.book = book;
    }

    /**
     * 获取格式ID
     *
     * @return format - 格式ID
     */
    public Integer getFormat() {
        return format;
    }

    /**
     * 设置格式ID
     *
     * @param format 格式ID
     */
    public void setFormat(Integer format) {
        this.format = format;
    }

    /**
     * 获取文件大小
     *
     * @return size - 文件大小
     */
    public Long getSize() {
        return size;
    }

    /**
     * 设置文件大小
     *
     * @param size 文件大小
     */
    public void setSize(Long size) {
        this.size = size;
    }
}