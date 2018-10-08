package com.think.multi.datasource.service.impl;

import com.think.multi.datasource.domain.User;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/19
 */
public interface UserServiceImpl {

    User findByName(String userName);
}
