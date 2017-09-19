package com.xjp.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 书名
     */
    private String name;

    /**
     * 作者
     */
    private String author;

    /**
     * 出版日期
     */
    private Date pubdate;

    /**
     * 大小(kb)
     */
    private Long size;

    /**
     * url路径
     */
    private String url;

    /**
     * 封面图片名称
     */
    private String cover;

    /**
     * 书籍简介
     */
    private String intro;

    /**
     * 亚马逊书城推荐地址
     */
    private String amazon;

    /**
     * 类别
     */
    private Integer type;

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
     * 获取书名
     *
     * @return name - 书名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置书名
     *
     * @param name 书名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取作者
     *
     * @return author - 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者
     *
     * @param author 作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取出版日期
     *
     * @return pubdate - 出版日期
     */
    public Date getPubdate() {
        return pubdate;
    }

    /**
     * 设置出版日期
     *
     * @param pubdate 出版日期
     */
    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    /**
     * 获取大小(kb)
     *
     * @return size - 大小(kb)
     */
    public Long getSize() {
        return size;
    }

    /**
     * 设置大小(kb)
     *
     * @param size 大小(kb)
     */
    public void setSize(Long size) {
        this.size = size;
    }

    /**
     * 获取url路径
     *
     * @return url - url路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置url路径
     *
     * @param url url路径
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取封面图片名称
     *
     * @return cover - 封面图片名称
     */
    public String getCover() {
        return cover;
    }

    /**
     * 设置封面图片名称
     *
     * @param cover 封面图片名称
     */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
     * 获取书籍简介
     *
     * @return intro - 书籍简介
     */
    public String getIntro() {
        return intro;
    }

    /**
     * 设置书籍简介
     *
     * @param intro 书籍简介
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }

    /**
     * 获取亚马逊书城推荐地址
     *
     * @return amazon - 亚马逊书城推荐地址
     */
    public String getAmazon() {
        return amazon;
    }

    /**
     * 设置亚马逊书城推荐地址
     *
     * @param amazon 亚马逊书城推荐地址
     */
    public void setAmazon(String amazon) {
        this.amazon = amazon;
    }

    /**
     * 获取类别
     *
     * @return type - 类别
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类别
     *
     * @param type 类别
     */
    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
      return "Book [id=" + id + ", name=" + name + ", author=" + author + ", pubdate=" + pubdate + ", size=" + size
          + ", url=" + url + ", cover=" + cover + ", intro=" + intro + ", amazon=" + amazon + ", type=" + type + "]";
    }
    
}