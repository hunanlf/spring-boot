package com.yf.quartz.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liufeng on 2018/7/3
 */
public class Task2 implements Job{
    static int count;
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        count++;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("我是第二个任务 : " + sdf.format(date)+"; count:"+count);
    }
}
