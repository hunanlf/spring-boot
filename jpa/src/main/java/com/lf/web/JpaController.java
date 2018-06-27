package com.lf.web;

import com.lf.auth.AopAnnotationTest;
import com.lf.entity.User;
import com.lf.service.UserRepository;
import com.lf.service.UserService;
import com.lf.util.Message;
import com.lf.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by liufeng on 2018/6/4
 */
@RestController
@AopAnnotationTest
public class JpaController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello(){
        System.out.println("JpaController.hello 11111");
        return "public String hello()";
    }

    @GetMapping("/test")
    public String test(){
        String test = userService.test();
        System.out.println("JpaController.test() 11111");
        return test ;
    }


    /**
     * <p>获取所有用户</p>
     * @return
     */
    @GetMapping("/users")
    public List<User> getUsers(){
        System.out.println("JpaController.getUsers");

        return userRepository.findAll();
    }

    /**
     *  <p>添加一个用户</p>
     * @return
     */
    @PostMapping("/add")
    public Message<User> addUser(@Valid User user, BindingResult bindingResult){
        if(bindingResult.hasErrors()){  //验证user对象，如有异常，则打印错误
            userService.getAge(user);
            //return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }

        user.setName(user.getName());
        user.setAge(user.getAge());
        User save = userRepository.save(user);
        return ResultUtil.success(save);
    }

    @PostMapping("/add1")
    public Message<User> addUser1(@Valid User user){
        User save = userRepository.save(user);
        return ResultUtil.success(save);
    }

    /**
     * <p>查询某个用户</p>
     * @param id
     * @return
     */
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id){
        User one = userRepository.findOne(id);
        return one;
    }

    /**
     * <p>删除某个用户</p>
     * @param id
     */
    @DeleteMapping("/user/{id}")
    public void delUser(@PathVariable("id") Integer id){
        userRepository.delete(id);
    }

    /**
     * <p>修改某个用户信息</p>
     * @param id
     * @param name
     * @param age
     * @return
     */
    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable("id") Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("age") Integer age){

        User user = new User();
        user.setId(id);
        user.setAge(age);
        user.setName(name);

        return userRepository.save(user);
    }

    /**
     * <p>根据年龄查询</p>
     * @param age
     * @return
     */
    @GetMapping("/user/age/{age}")
    public List<User> findByAge(@PathVariable("age") Integer age){
        List<User> byAge = userRepository.findByAge(age);
        return byAge;
    }

}
