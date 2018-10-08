package com.boot.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.boot.domain.User;
import com.boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/9/25
 */
@RestController
@RequestMapping("v1")
public class UserController {

//    @Reference(version = "1.0.0")//
    @Autowired
    private UserService userService;

    @GetMapping("/findUser")
    public User findUser(){
        return userService.findUser();
    }


}
