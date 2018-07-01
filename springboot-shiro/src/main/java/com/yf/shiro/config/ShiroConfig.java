package com.yf.shiro.config;

import com.yf.shiro.realm.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by 10059 on 2018/6/30
 * shiro 配置类
 */
@Configuration
public class ShiroConfig {
    /*
        创建ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 添加shiro内置过滤器
        /*
              anon :无需认证，登录访问
              authc: 必须认证才可以
              user： 如果使用rememberMe的功能才可以访问
              perms: 该资源必须得到资源权限
              role: 该资源必须得到角色权限
         */
        Map<String,String> mapFilter = new LinkedHashMap<>();
        mapFilter.put("/hello/index","anon");
        //放行登录界面
        mapFilter.put("/hello/testLogin","anon");

        // 授权拦截
        mapFilter.put("/hello/add","perms[user:add]");
        mapFilter.put("/hello/update","perms[user:update]");

        /*
            设置授权失败的返回页面
         */
        shiroFilterFactoryBean.setUnauthorizedUrl("/hello/unauth");
        mapFilter.put("/hello/*","authc");
        /*
            返回认证失败，会默认返回 login.jsp,我们这里修改路径
         */
        shiroFilterFactoryBean.setLoginUrl("/hello/login");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(mapFilter);
        return shiroFilterFactoryBean;
    }

    /*
        创建DefaultWebSecurityManager
     */
    @Bean(name="securityManager")
    public DefaultWebSecurityManager  getSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        //关联realm
        manager.setRealm(userRealm);
        return manager;
    }

    /*
        创建realm
     */
    @Bean(name="userRealm")
    public UserRealm getRealm(){
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }
}
