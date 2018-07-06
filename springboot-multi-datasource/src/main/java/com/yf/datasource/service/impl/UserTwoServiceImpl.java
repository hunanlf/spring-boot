package com.yf.datasource.service.impl;

import com.yf.datasource.entity.UserTwo;
import com.yf.datasource.mapper.two.UserTwoMapper;
import com.yf.datasource.service.UserTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liufeng on 2018/7/6
 */
@Service
public class UserTwoServiceImpl implements UserTwoService {

    @Autowired
    private UserTwoMapper userTwoMapper;

    @Override
    public UserTwo getUserTwo(int id) {
        return userTwoMapper.getUserTwo(id);
    }

    @Override
    public int addUserTwo(UserTwo userTwo) {
        return userTwoMapper.addUserTwo(userTwo);
    }
}
