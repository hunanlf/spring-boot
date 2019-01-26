package com.yf.testsecurity.config

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder

/*@Configuration
@EnableWebSecurity*/
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    @Throws(Exception::class)
    protected override fun configure(http: HttpSecurity) {
        http.authorizeRequests()//配置安全策略
                .antMatchers("/", "/hello").permitAll()//定义/请求不需要验证
                .anyRequest().authenticated()//其余的所有请求都需要验证
                .and()
                .logout()
                .permitAll()//定义logout不需要验证
                .and()
                .formLogin()//使用form表单登录
    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder?) {
//        auth!!.inMemoryAuthentication().withUser("lf").password("123").roles("USER");
        //java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null" 报错日志
        auth!!.inMemoryAuthentication().passwordEncoder(BCryptPasswordEncoder()).withUser("lf")
                .password(BCryptPasswordEncoder().encode("123")).roles("USER");
    }
}