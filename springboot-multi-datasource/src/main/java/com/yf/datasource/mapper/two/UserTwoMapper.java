package com.yf.datasource.mapper.two;

import com.yf.datasource.entity.UserTwo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by liufeng on 2018/7/6
 */
public interface UserTwoMapper {

    @Select("select * from user_two where id = #{id}")
    public UserTwo getUserTwo(int id);

    @Insert("insert into user_two(id,`name`) values(#{id},#{name})")
    public int addUserTwo(UserTwo userTwo);

}
