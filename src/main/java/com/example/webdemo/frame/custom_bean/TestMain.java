package com.example.webdemo.frame.custom_bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestMain {
    public static void main(String[] args) {
        BeanFactory factory = new XmlBeanFactory(new ClassPathResource("static/custom/zld_scope.xml"));
        DatasourceInfo myDataSource = factory.getBean("myDataSource1", DatasourceInfo.class);
        System.out.println(myDataSource);
        System.out.println(myDataSource.hashCode());
        DatasourceFactoryBean myDataSource1 = factory.getBean("&myDataSource1", DatasourceFactoryBean.class);
        System.out.println(myDataSource1);
        System.out.println(myDataSource1.hashCode());
    }
}
