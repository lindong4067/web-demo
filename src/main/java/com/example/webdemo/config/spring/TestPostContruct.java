package com.example.webdemo.config.spring;

import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author Lindong Zhao
 * @PostContruct
 * @create 2019-03-09 20:27
 **/
@Configuration
public class TestPostContruct {
    @PostConstruct
    public void init(){
        System.out.println("My Post Construct");
    }
}
