package com.think.multi.datasource.dao.cluster;

import com.think.multi.datasource.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/19
 */
@Mapper
public interface CityMapper {

    City findByName(@Param("cityName") String cityName);

    City findById(@Param("id") int id);

}
