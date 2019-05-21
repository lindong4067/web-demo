package com.example.webdemo.frame.aopdemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestAop {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("static/aop/aop_demo.xml");
        Dao dao = (Dao) applicationContext.getBean("daoImpl");
        System.out.println(dao);
        dao.insert();
        dao.select();
    }
}
