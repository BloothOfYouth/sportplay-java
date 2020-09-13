package com.hjf.sportplay.entity;

import java.io.Serializable;
import java.util.List;

/**
 * (Mainmenu)实体类
 *
 * @author hjf
 * @since 2020-09-11 19:00:57
 */
public class Mainmenu implements Serializable {

    /**
    * 主键
    */
    private Integer id;

    private String title;

    private String path;

    private List<Submenu> submenus;


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

    public void setSubmenus(List<Submenu> submenus) {
        this.submenus = submenus;
    }

    public List<Submenu> getSubmenus() {
        return submenus;
    }

    @Override
    public String toString() {
        return "Mainmenu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", path='" + path + '\'' +
                ", submenus=" + submenus +
                '}';
    }
}
