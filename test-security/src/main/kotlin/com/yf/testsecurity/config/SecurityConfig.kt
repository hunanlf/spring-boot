package com.yf.testsecurity.config

import org.jasig.cas.client.session.SingleSignOutFilter
import org.jasig.cas.client.validation.Cas20ServiceTicketValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.cas.ServiceProperties
import org.springframework.security.cas.authentication.CasAuthenticationProvider
import org.springframework.security.cas.web.CasAuthenticationEntryPoint
import org.springframework.security.cas.web.CasAuthenticationFilter
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.web.authentication.logout.LogoutFilter
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
class SecurityConfig: WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var customUserDetailsService:CustomUserDetailsService

    @Autowired
    lateinit var casAuthenticationProvider:CasAuthenticationProvider

    @Autowired
    lateinit var casAuthenticationEntryPoint:CasAuthenticationEntryPoint

    @Autowired
    lateinit var casLogoutFilter:LogoutFilter

    @Autowired
    lateinit var singleSignOutFilter:SingleSignOutFilter

    override fun configure(auth: AuthenticationManagerBuilder) {
        super.configure(auth)
        auth.authenticationProvider(casAuthenticationProvider)
    }

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests()//配置安全策略
                .antMatchers("/", "/hello").permitAll()//定义/请求不需要验证
                .anyRequest().authenticated()//其余的所有请求都需要验证
                .and()
                .logout()
                .permitAll()//定义logout不需要验证
                .and()
                .formLogin()//使用form表单登录

        http.exceptionHandling().authenticationEntryPoint(casAuthenticationEntryPoint)
                .and()
                .addFilter(casAuthenticationFilter())
                .addFilterBefore(casLogoutFilter, LogoutFilter::class.java)
                .addFilterBefore(singleSignOutFilter, CasAuthenticationFilter::class.java)
    }

    /**
     * http://192.168.4.177:8082             本地项目的首页访问地址
     * https://dev.yifenganxin.com:9443      连接的cas服务器地址
     * 根据自己的服务器路径对应修改
     */

    /**CAS服务*/
    @Bean
    fun serviceProperties(): ServiceProperties {
        val serviceProperties=ServiceProperties();
        //本地项目的路径+login/cas
        serviceProperties.service="http://192.168.4.177:8082/login/cas"
        serviceProperties.isAuthenticateAllArtifacts=true
        return serviceProperties
    }

    /**CAS身份验证过程*/
    @Bean
    fun casAuthenticationEntryPoint(): CasAuthenticationEntryPoint {
        var casAuthenticationEntryPoint = CasAuthenticationEntryPoint()
        casAuthenticationEntryPoint.loginUrl = "https://dev.yifenganxin.com:9443/cas/login"
        casAuthenticationEntryPoint.serviceProperties = serviceProperties()
        return casAuthenticationEntryPoint
    }

    /**CAS认证过滤器*/
    @Bean
    fun casAuthenticationFilter(): CasAuthenticationFilter{
        var casAuthenticationFilter = CasAuthenticationFilter()
        casAuthenticationFilter.setAuthenticationManager(authenticationManager())
        casAuthenticationFilter.setFilterProcessesUrl("/cas/login")
        return casAuthenticationFilter
    }

    /** 认证Provider消息*/
    @Bean
    fun casAuthenticationProvider(): CasAuthenticationProvider{
        var casAuthenticationProvider = CasAuthenticationProvider()
        casAuthenticationProvider.setAuthenticationUserDetailsService(customUserDetailsService)
        casAuthenticationProvider.setTicketValidator(Cas20ServiceTicketValidator("https://dev.yifenganxin.com:9443/cas"))
        casAuthenticationProvider.setServiceProperties(serviceProperties())
        casAuthenticationProvider.setKey("an_id_for_this_auth_provider_only")
        return casAuthenticationProvider
    }

    /**单点登出过滤器 */
    @Bean
    fun singleSignOutFilter(): SingleSignOutFilter {
        val singleSignOutFilter = SingleSignOutFilter()
        singleSignOutFilter.setCasServerUrlPrefix("https://dev.yifenganxin.com:9443/cas")
        singleSignOutFilter.setIgnoreInitConfiguration(true)
        return singleSignOutFilter
    }

    /**请求单点退出过滤器 */
    @Bean
    fun casLogoutFilter(): LogoutFilter {
        val logoutFilter = LogoutFilter("https://dev.yifenganxin.com:9443/cas/logout?service=http://192.168.4.177:8082", SecurityContextLogoutHandler())
        logoutFilter.setFilterProcessesUrl("/logout")
        return logoutFilter
    }
}

