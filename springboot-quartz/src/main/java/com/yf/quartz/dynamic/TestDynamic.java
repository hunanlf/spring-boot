package com.yf.quartz.dynamic;

import com.yf.quartz.task.Task1;
import com.yf.quartz.task.Task2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liufeng on 2018/7/6
 */
@Component
public class TestDynamic implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        String str = "11,12,15,18,19,22,23,24,25,26";

        String[] cron = str.split(",");

        List<String> one = new ArrayList<>();
        List<String> two = new ArrayList<>();

        for(int i = 0;i<cron.length;i+=2){
            one.add(cron[i]);
        }
        for(int i = 1;i<cron.length;i+=2){
            two.add(cron[i]);
        }

        QuartzDynamic qt=new QuartzDynamic();

        //执行第一个任务的
        if (null != one) {
            for(int i=0;i< one.size();i++) {
                String json = "0"+" "+one.get(i) +" 10 * * ?";
                qt.addJob1("one"+i,"one"+i,"one"+i,"one"+i,Task1.class,json);
            }
        }

        //执行第二个任务的
        if (null != two ) {
            for(int i=0;i< two.size();i++) {
                String json = "0"+" "+two.get(i) +" 10 * * ?";
                qt.addJob1("two"+i,"two"+i,"two"+i,"two"+i,Task2.class,json);
            }
        }
    }
}
