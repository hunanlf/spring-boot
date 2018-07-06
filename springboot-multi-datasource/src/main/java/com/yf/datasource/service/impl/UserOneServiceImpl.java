package com.yf.datasource.service.impl;

import com.yf.datasource.entity.UserOne;
import com.yf.datasource.mapper.one.UserOneMapper;
import com.yf.datasource.service.UserOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by liufeng on 2018/7/6
 */
@Service
public class UserOneServiceImpl implements UserOneService {

    @Autowired
    private UserOneMapper userOneMapper;

    @Override
    public UserOne getUserOne(int id) {
        return userOneMapper.getUserOne(id);
    }

    @Override
    public int addUserOne(UserOne userOne) {
        return userOneMapper.addUserOne(userOne);
    }
}
