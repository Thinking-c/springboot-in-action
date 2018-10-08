package com.chargedot.malfunction.dao.mapper;

import com.chargedot.malfunction.dao.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * test mapper
 */
@Mapper
public interface UserMapper {

	@Insert("insert sys_user(id,user_name) values(#{id},#{userName})")
	void insert(User u);
	
	@Select("select id,user_name from sys_user where id=#{id} ")
	User findById(@Param("id") String id);

	List<User> query(@Param("userName") String userName);
	
}
