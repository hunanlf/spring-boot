package com.yf.datasource.controller;

import com.yf.datasource.entity.UserOne;
import com.yf.datasource.entity.UserTwo;
import com.yf.datasource.service.UserOneService;
import com.yf.datasource.service.UserTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by liufeng on 2018/7/6
 */
@RestController
public class UserController {

      @Autowired
      private UserOneService userOneService;

      @Autowired
      private UserTwoService userTwoService;


      @GetMapping("/user")
      public String user(){
          return "###########hello user############";
      }

    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping("/one/getUserOne")
      public String getUserOne(int id){
          UserOne userOne = userOneService.getUserOne(id);
          return userOne.toString();
      }

    /**
     * 添加用户
     * @param userOne
     * @return
     */
      @PostMapping("/one/addUserOne")
      public String addUserOne(@Valid UserOne userOne){
          int i = userOneService.addUserOne(userOne);
          String json = null;
          if(i>0){
             json = "添加成功："+userOne.getName();
          }else {
              json = "添加失败";
          }
          return json;
      }


    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping("/two/getUserTwo")
    public String getUserTwo(int id){
        UserTwo userTwo = userTwoService.getUserTwo(id);
        return userTwo.toString();
    }

    /**
     * 添加用户
     * @param userTwo
     * @return
     */
    @PostMapping("/two/addUserTwo")
    public String addUserTwo(@Valid UserTwo userTwo){
        int i = userTwoService.addUserTwo(userTwo);
        String json = null;
        if(i>0){
            json = "添加成功："+userTwo.getName();
        }else {
            json = "添加失败";
        }
        return json;
    }
}
