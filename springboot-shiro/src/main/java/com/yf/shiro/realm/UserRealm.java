package com.yf.shiro.realm;

import com.yf.shiro.entity.User;
import com.yf.shiro.service.RolesService;
import com.yf.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by 10059 on 2018/6/30
 * 自定义realm类
 */
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Autowired
    private RolesService rolesService;

    /*
        执行授权逻辑
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("##########执行授权操作#########");
        /*
            授权逻辑
         */
        SimpleAuthorizationInfo sa = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();

        //查出该用户所有的权限
        if(user != null){
            List<String> listRoles = rolesService.findByName(user.getName());
            sa.addStringPermissions(listRoles);
        }
        return sa;
    }

    /*
        执行认证逻辑
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        System.out.println("#########执行认证逻辑#######");
        UsernamePasswordToken token = (UsernamePasswordToken)auth;
        /*
            认证逻辑，用户传过来的name，根据name查询数据库
         */
        String username = token.getUsername();
        User user = userService.findByName(username);
        System.out.println("token user:"+user);
        if(user == null){
            return null;
        }
        /*
            new SimpleAuthenticationInfo("",user.getPassword(),"")说明

            arg0:subject.getPrincipal()返回的值
            Subject subject = SecurityUtils.getSubject();
            Object principal = subject.getPrincipal();
           arg1: 密码
           arg2：realm name
         */
        return new SimpleAuthenticationInfo(user,user.getPassword(),"");
    }
}
