package com.yf.quartz.task;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liufeng on 2018/7/3
 */
@Configuration
@Component // 此注解必加
@EnableScheduling // 此注解必加
public class ScheduleTask{
    static  int count;
    public void execute(){
        count++;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("HelloJob time : " + sdf.format(date)+"; count:"+count);
    }
}