package com.hjf.sportplay.entity;

import java.io.Serializable;

/**
 * (Submenu)实体类
 *
 * @author hjf
 * @since 2020-09-11 19:01:10
 */
public class Submenu implements Serializable {


    private Integer id;

    private String title;

    private String path;

    private Integer mid;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    @Override
    public String toString() {
        return "Submenu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", mid=" + mid +
                '}';
    }
}
