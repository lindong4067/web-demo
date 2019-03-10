package com.example.webdemo.config.spring;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;

/**
 * Test Initializing Bean
 *
 * @author Lindong Zhao
 * @create 2019-03-09 20:31
 **/
@Configuration
public class TestInitializingBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("My Initializing Bean");
    }
}
