package com.lf.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 * Created by liufeng on 2018/6/4
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc  //测试controller
public class JpaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public  void getUsers() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk());
                //.andExpect(MockMvcResultMatchers.content().string("55")); //结果预判
    }

}