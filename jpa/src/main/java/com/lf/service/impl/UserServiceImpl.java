package com.lf.service.impl;

import com.lf.entity.User;
import com.lf.service.UserService;
import com.lf.util.ResultEnum;
import com.lf.util.UserException;
import org.springframework.stereotype.Service;

/**
 * Created by liufeng on 2018/6/4
 */
@Service
public class UserServiceImpl implements UserService{

    @Override
    public void getAge(User user) {
        Integer age = user.getAge();
        if (age < 10) {
            throw new UserException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age > 10 && age < 16) {
            throw new UserException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    public String test() {
        System.out.println("UserServiceImpl.test");
      return "UserServiceImpl method test()";
    }
}
