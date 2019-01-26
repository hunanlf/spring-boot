package com.yf.shiro.mapper;

import com.yf.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by 10059 on 2018/6/30
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM `user` WHERE `name` = #{name}")
    public User findByName(String name);

}
