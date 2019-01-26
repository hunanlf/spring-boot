package com.yf.shiro.controller;

import com.yf.shiro.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by liufeng on 2018/6/29
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "hello springboot shiro";
    }

    /**
     * 用户的添加
     * @return
     */
    @GetMapping("/add")
    public String add(){
        return "/user/add";
    }

    /**
     * 用户的修改
     * @return
     */
    @GetMapping("/update")
    public String update(){
        return "/user/update";
    }

    /**
     * 测试 thymeleaf
     * @param
     * @return
     */
    @RequestMapping("/index")
    public String testThymeleaf(Model model){
        model.addAttribute("name","springboot shiro");
        //map.put("name","springboot shiro");
        return "index";
    }

    /*
        没有登录返回的界面
     */
    @GetMapping("/login")
    public String login(){
        return "/login";
    }

    /**
     * 认证登录信息
     * @return
     */
    @PostMapping("/testLogin")
    public String testLogin(User user,Model model){
        System.out.println("user:"+user);
        //获取subject
        Subject subject = SecurityUtils.getSubject();
        // 封装用户信息
        UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),user.getPassword());
        // 执行登录
        try { // 登录成功
            subject.login(token);
            return "redirect:index";
        }catch (UnknownAccountException e){
            // 登录失败
            model.addAttribute("msg","用户名不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            // 登录失败
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }

    @GetMapping("/unauth")
    public String unauth(){  //未授权页面
        return "unauth";
    }

    @GetMapping("/ftl")
    public String testFtl(Map<String,String> map){
        map.put("name","springboot ftl");
        //map.put("name","springboot shiro");
        return "test";
    }
}
