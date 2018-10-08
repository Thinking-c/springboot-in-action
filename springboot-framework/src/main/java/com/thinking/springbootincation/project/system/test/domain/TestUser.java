package com.thinking.springbootincation.project.system.test.domain;

import lombok.Data;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/13
 */
@Data
public class TestUser {

    private Integer id;
    private String username;
    private String password;

    public TestUser() {
    }

    public TestUser(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "TestUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
