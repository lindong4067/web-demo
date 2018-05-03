

package com.example.webdemo.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AwareTest implements BeanFactoryAware, ApplicationContextAware{

    private BeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    public void testAware(){
        Hello hello = (Hello) beanFactory.getBean("hello");
        hello.say();
    }

    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        AwareTest test = (AwareTest) ctx.getBean("test");
//        test.testAware();
        AwareTest test = (AwareTest) applicationContext.getBean("awareTest");
        test.testAware();
    }

    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        AwareTest.applicationContext = applicationContext;
    }
}

