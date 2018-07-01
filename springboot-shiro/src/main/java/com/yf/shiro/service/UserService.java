package com.yf.shiro.service;

import com.yf.shiro.entity.User;

/**
 * Created by 10059 on 2018/6/30
 */
public interface UserService {
    public User findByName(String name);
}
