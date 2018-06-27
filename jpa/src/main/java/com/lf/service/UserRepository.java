package com.lf.service;

import com.lf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by liufeng on 2018/6/4
 */
public interface UserRepository extends JpaRepository<User,Integer>{
    // Integer 是id的类型

     //根据年龄查询
     List<User> findByAge(Integer age);

}
