package com.example.webdemo.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * My Application Runner
 *
 * @author Lindong Zhao
 * @create 2019-03-09 20:22
 **/
@Component
public class MyApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("My Application Runner Start");
        System.out.println("My Application Runner Stop");
    }
}
