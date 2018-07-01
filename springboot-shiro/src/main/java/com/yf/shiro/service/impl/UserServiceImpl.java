package com.yf.shiro.service.impl;

import com.yf.shiro.entity.User;
import com.yf.shiro.mapper.UserMapper;
import com.yf.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 10059 on 2018/6/30
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByName(String name) {
        return userMapper.findByName(name);
    }

}
