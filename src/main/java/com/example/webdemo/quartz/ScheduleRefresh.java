
//
//package com.example.webdemo.quartz;
//
//import com.example.webdemo.utils.ConsulUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.quartz.*;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
//@Slf4j
//@Component
//public class ScheduleRefresh {
//
//    @Resource(name = "jobDetail")
//    private JobDetail jobDetail;
//
//    @Resource(name = "jobTrigger")
//    private CronTrigger cronTrigger;
//
//    @Resource(name = "scheduler")
//    private Scheduler scheduler;
//
//    @Scheduled(fixedRate = 5000) // 每隔5s查库，并根据查询结果决定是否重新设置定时任务
//    public void scheduleUpdateCronTrigger() throws SchedulerException {
//        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(cronTrigger.getKey());
//        String currentCron = trigger.getCronExpression();// 当前Trigger使用的
//        String searchCron = ConsulUtil.getKV("cron");// 从Consul查询出来的
//        System.out.println(currentCron);
//        System.out.println(searchCron);
//        if (currentCron.equals(searchCron)) {
//            log.info("如果当前使用的cron表达式和从Consul中查询出来的cron表达式一致，则不刷新任务");
//        }else {
////             表达式调度构建器
//            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(searchCron);
//            // 按新的cronExpression表达式重新构建trigger
////            trigger = (CronTrigger) scheduler.getTrigger(cronTrigger.getKey());
//            trigger = trigger.getTriggerBuilder().withIdentity(cronTrigger.getKey())
//                    .withSchedule(scheduleBuilder).build();
////            // 按新的trigger重新设置job执行
//            scheduler.rescheduleJob(cronTrigger.getKey(), trigger);
////            currentCron = searchCron;
//        }
//    }
//}
