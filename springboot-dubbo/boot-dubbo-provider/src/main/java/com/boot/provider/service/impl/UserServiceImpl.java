package com.boot.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.boot.domain.User;
import com.boot.service.UserService;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/9/25
 */
//@Service(version = "1.0.0") //sprig-dubbo中配置了扫描包路径就是注解开发
public class UserServiceImpl implements UserService {


    @Override
    public User findUser() {

        User user = new User();
        user.setId(123);
        user.setUsername("张三");
        user.setPassword("123456");
        user.setAge(18);
        user.setGender("男");

        return user;
    }
}
