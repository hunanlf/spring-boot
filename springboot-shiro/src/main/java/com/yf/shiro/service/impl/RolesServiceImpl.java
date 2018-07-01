package com.yf.shiro.service.impl;

import com.yf.shiro.mapper.RolesMapper;
import com.yf.shiro.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 10059 on 2018/6/30
 */
@Service
public class RolesServiceImpl implements RolesService{

    @Autowired
    private RolesMapper rolesMapper;

    @Override
    public List<String> findByName(String name) {
        return rolesMapper.findByName(name);
    }
}
