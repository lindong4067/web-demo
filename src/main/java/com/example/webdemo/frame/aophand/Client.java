package com.example.webdemo.frame.aophand;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("static/aop/aop_hand.xml");
        Master master = (Master) ((ProxyFactoryBean)applicationContext.getBean("humanProxy")).getProxyBean();
        master.shopping();
        master.walkDog();
    }
}
