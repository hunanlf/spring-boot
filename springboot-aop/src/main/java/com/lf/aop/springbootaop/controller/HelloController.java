package com.lf.aop.springbootaop.controller;

import com.lf.aop.springbootaop.service.AopAnnotationTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lf
 * @描述
 * @date 2018-10-09
 */
@RestController
@AopAnnotationTest
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        System.out.println("HelloController.hello 11111");
        return "public String hello()";
    }

}
