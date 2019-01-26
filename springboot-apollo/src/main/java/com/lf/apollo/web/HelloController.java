package com.lf.apollo.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lf
 * @描述
 * @date 2019-01-18
 */
@RestController
public class HelloController {

    @Value("${hello:apollo.hello}")
    private String hello;

    @Value("${cache:apollo.cache}")
    private String cache;

    @GetMapping("/hello")
    public String hello() {

        return hello + " ;cache:" + cache;
    }

}
