package com.yf.shiro.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by 10059 on 2018/6/30
 */
@Mapper
public interface RolesMapper {

    @Select("select permission_name from roles where `name` = #{name}")
    @Results({
            @Result(column = "permission_name", property = "permissionName"),
    })
    public List<String> findByName(String name);

}
