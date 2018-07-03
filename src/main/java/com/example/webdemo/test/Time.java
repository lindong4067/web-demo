

package com.example.webdemo.test;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

//@Component
public class Time {

    //    @Scheduled(cron = "0/2 * * * * *") 0/10 * * * * ?
    public void timer1() {
        LocalDateTime localDateTime = LocalDateTime.now();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("当前时间为:" + localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    //    @Scheduled(fixedDelay = 5000)
//    @Async
    public void job1() {
        System.out.println(Thread.currentThread() + ", job1@" + LocalTime.now());
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
        }
    }

    //    @Scheduled(fixedDelay = 5000)
//    @Async
    public void job2() {
        System.out.println(Thread.currentThread() + ", job2@" + LocalTime.now());
    }
}
