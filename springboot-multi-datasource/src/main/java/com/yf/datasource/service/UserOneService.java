package com.yf.datasource.service;

import com.yf.datasource.entity.UserOne;

/**
 * Created by liufeng on 2018/7/6
 */
public interface UserOneService {
    public UserOne getUserOne(int id); // 根据id查询

    public int addUserOne(UserOne userOne);

}
