package com.xjp.model;

import javax.persistence.*;

@Table(name = "cms_test")
public class CmsTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String namee;

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
     * @return namee
     */
    public String getNamee() {
        return namee;
    }

    /**
     * @param namee
     */
    public void setNamee(String namee) {
        this.namee = namee;
    }
}