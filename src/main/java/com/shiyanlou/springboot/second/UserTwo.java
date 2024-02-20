package com.shiyanlou.springboot.second;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 设置表名为 user_two，并标记该类为实体类
 */
@Table(name = "user_two")
@Entity
public class UserTwo {

    /**
     * 设置主键生成策略
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public int id;

    @Column
    private String username;

    @Column
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username='" + username + '\'' + ", password='" + password + '\'' + "}";
    }
}
