package com.hjf.sportplay.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

/**
 * (Easyuser)实体类
 *
 * @author hjf
 * @since 2020-09-06 15:26:43
 */
public class Easyuser implements Serializable {

    /**
    * 主键
    */
    @TableId(type = IdType.AUTO)
    private Integer id;
    /**
    * 账号
    */
    private String username;
    /**
    * 密码
    */
    private String password;
    /**
    * 邮箱
    */
    private String email;
    /**
    * 角色
    */
    private String role;
    /**
    * 状态
    */
    private Boolean state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Easyuser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", state=" + state +
                '}';
    }
}
