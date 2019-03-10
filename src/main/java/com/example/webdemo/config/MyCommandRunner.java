package com.example.webdemo.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * My Command Runner
 *
 * @author Lindong Zhao
 * @create 2019-03-09 20:14
 **/
@Component
public class MyCommandRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("My Command Runner Start...");
//        wait(3000);
        System.out.println("My Command Runner Stop...");
    }
}
