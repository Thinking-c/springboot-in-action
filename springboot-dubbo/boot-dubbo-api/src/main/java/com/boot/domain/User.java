package com.boot.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/9/25
 */
@Data
public class User implements Serializable {

    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String gender;

}
