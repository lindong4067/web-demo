///*
// *         File : QuartzConfig.java
// *    Classname : QuartzConfig
// *    Author(s) : EZNLZHI
// *      Created : 2018-03-16
// *
// * Copyright (c) 2017 Ericsson AB, Sweden.
// * All rights reserved.
// * The Copyright to the computer program(s) herein is the property of
// * Ericsson AB, Sweden.
// * The program(s) may be used and/or copied with the written permission
// * from Ericsson AB or in accordance with the terms and conditions
// * stipulated in the agreement/contract under which the program(s)
// * have been supplied.
// *
// */
//
//package com.example.webdemo.config;
//
//import com.example.webdemo.quartz.ScheduleTask;
//import org.quartz.Trigger;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
//import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
//import org.springframework.scheduling.quartz.SchedulerFactoryBean;
//
//@Configuration
//public class QuartzConfig {
//    /**
//     * 配置一个定时任务
//     * @param task
//     * @return
//     */
//    @Bean(name = "jobDetail")
//    public MethodInvokingJobDetailFactoryBean detailFactoryBean(ScheduleTask task){
//        MethodInvokingJobDetailFactoryBean jobDetail = new MethodInvokingJobDetailFactoryBean();
//        //是否支持并发执行
//        jobDetail.setConcurrent(false);
//        //设置任务名
//        jobDetail.setName("hello-task");
//        //设置任务分组
//        jobDetail.setGroup("hello");
//        //需要执行的实体对应的对象
//        jobDetail.setTargetObject(task);
//        //需要执行的方法
//        jobDetail.setTargetMethod("sayHello");
//        return jobDetail;
//    }
//
//    @Bean(name = "jobTrigger")
//    public CronTriggerFactoryBean cronTrigger(MethodInvokingJobDetailFactoryBean jobDetail){
//        CronTriggerFactoryBean trigger = new CronTriggerFactoryBean();
//        trigger.setJobDetail(jobDetail.getObject());
//        trigger.setCronExpression("0 30 20 * * ?");
//        trigger.setName("hello-trigger");
//        return trigger;
//    }
//
//    @Bean(name = "scheduler")
//    public SchedulerFactoryBean schedulerFactory(Trigger cronTrigger) {
//        SchedulerFactoryBean bean = new SchedulerFactoryBean();
//        // 用于quartz集群,QuartzScheduler 启动时更新己存在的Job
//        bean.setOverwriteExistingJobs(true);
//        // 延时启动，应用启动1秒后
//        bean.setStartupDelay(1);
//        // 注册触发器
//        bean.setTriggers(cronTrigger);
//        return bean;
//    }
//}
