package com.example.webdemo.quartz.demo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        int index = context.getJobDetail().getJobDataMap().getIntValue("index");
        System.out.println("Hello World! index : " + index );
    }
}
