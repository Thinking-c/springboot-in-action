package com.thinking.springbootincation.project.system.test.mapper;

import com.thinking.springbootincation.project.system.test.domain.TestUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/13
 */
@Mapper
public interface TestUserMapper {

    List<TestUser> getUsers();
}
