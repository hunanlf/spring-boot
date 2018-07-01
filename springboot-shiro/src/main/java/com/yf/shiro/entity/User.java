package com.yf.shiro.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by 10059 on 2018/6/30
 */
@Data
@Component
public class User {
    private int id;

    private String name;

    private String password;
}
