package com.yf.shiro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/ftl")
    public String testFtl(Map<String,String> map){
        map.put("name","springboot ftl");
        //map.put("name","springboot shiro");
        return "test";
    }
}
