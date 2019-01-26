package com.yf.quartz.dynamic;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by liufeng on 2018/7/6
 */
public class QuartzDynamic {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        /**
         * @Description: 添加一个定时任务
         * @param jobName 任务名
         * @param jobGroupName  任务组名
         * @param triggerName 触发器名
         * @param triggerGroupName 触发器组名
         * @param jobClass  任务
         * @param cron   时间设置，参考quartz说明文档
         */
        public void addJob1(String jobName, String jobGroupName,String triggerName, String triggerGroupName, Class jobClass, String cron) {
            try {
                Scheduler sched = schedulerFactory.getScheduler();
                // 任务名，任务组，任务执行类
                JobDetail jobDetail= JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();

                // 触发器
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                // 触发器名,触发器组
                triggerBuilder.withIdentity(triggerName, triggerGroupName);
                triggerBuilder.startNow();
                // 触发器时间设定
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
                // 创建Trigger对象
                CronTrigger trigger = (CronTrigger) triggerBuilder.build();

                // 调度容器设置JobDetail和Trigger
                sched.scheduleJob(jobDetail, trigger);

                // 启动
                if (!sched.isShutdown()) {
                    sched.start();
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

    }

