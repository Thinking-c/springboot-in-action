package com.thinking.springbootincation.project.system.test.service;

import com.thinking.springbootincation.project.system.test.domain.TestUser;

import java.util.List;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/13
 */
public interface TestUserService {

    List<TestUser> getUsers();
}
