package com.think.multi.datasource.dao.master;

import com.think.multi.datasource.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/19
 */
@Mapper
public interface UserMapper {

    User findByName(@Param("userName") String userName);
}
