package com.yf.testsecurity.controller

import org.springframework.security.access.annotation.Secured
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class SecurityController {

    @GetMapping("/hello")
    fun hello(): String{
        return "无需验证"
    }

    @GetMapping("/security")
    @Secured("ROLE_TEST")
//    @PreAuthorize("hasAuthority('TEST')")
    @ResponseBody
    fun security(): String{
        return "验证成功"
    }

}