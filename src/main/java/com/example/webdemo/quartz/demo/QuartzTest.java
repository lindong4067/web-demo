package com.example.webdemo.quartz.demo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzTest {
    public static void main(String[] args) {
        try {
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
            scheduler.start();

            int index = 100;
            JobDetail jobDetail = newJob(HelloJob.class)
                    .withIdentity("helloJob", "group1")
                    .usingJobData("index", index)
                    .build();

            Trigger trigger = newTrigger()
                    .withIdentity("helloTrigger", "group1")
                    .withSchedule(
                            simpleSchedule()
                                    .withIntervalInSeconds(5)
                                    .repeatForever()
                    )
                    .build();

            scheduler.scheduleJob(jobDetail, trigger);

            Thread.sleep(20000);
            scheduler.shutdown();
        } catch (SchedulerException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
