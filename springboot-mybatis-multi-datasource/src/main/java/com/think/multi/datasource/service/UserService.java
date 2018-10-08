package com.think.multi.datasource.service;

import com.think.multi.datasource.dao.cluster.CityMapper;
import com.think.multi.datasource.dao.master.UserMapper;
import com.think.multi.datasource.domain.City;
import com.think.multi.datasource.domain.User;
import com.think.multi.datasource.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/19
 */
@Service
public class UserService implements UserServiceImpl {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CityMapper cityMapper;

    @Override
    public User findByName(String userName) {
        User user = userMapper.findByName(userName);
        City city = cityMapper.findByName("上海市");
//        City city = cityMapper.findById(1);
        user.setCity(city);
        return user;
    }
}
