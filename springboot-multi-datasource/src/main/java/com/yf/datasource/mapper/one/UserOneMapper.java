package com.yf.datasource.mapper.one;

import com.yf.datasource.entity.UserOne;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by liufeng on 2018/7/6
 */
public interface UserOneMapper {

    @Select("select * from user_one where id = #{id}")
    public UserOne getUserOne(int id);

    @Insert("insert into user_one(id,`name`) values(#{id},#{name})")
    public int addUserOne(UserOne userOne);

}
