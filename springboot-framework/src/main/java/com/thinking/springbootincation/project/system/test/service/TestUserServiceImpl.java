package com.thinking.springbootincation.project.system.test.service;

import com.thinking.springbootincation.project.system.test.mapper.TestUserMapper;
import com.thinking.springbootincation.project.system.test.domain.TestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/13
 */
@Service
public class TestUserServiceImpl implements TestUserService {

    @Autowired
    private TestUserMapper testUserMapper;

    @Override
    public List<TestUser> getUsers() {
       return testUserMapper.getUsers();
    }
}
