/*
 *         File : ContextTest.java
 *    Classname : ContextTest
 *    Author(s) : EZNLZHI
 *      Created : 2018-03-20
 *
 * Copyright (c) 2017 Ericsson AB, Sweden.
 * All rights reserved.
 * The Copyright to the computer program(s) herein is the property of
 * Ericsson AB, Sweden.
 * The program(s) may be used and/or copied with the written permission
 * from Ericsson AB or in accordance with the terms and conditions
 * stipulated in the agreement/contract under which the program(s)
 * have been supplied.
 *
 */

package com.example.webdemo.frame.ioc;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ContextTest {
    @Test
    public void test(){
        ApplicationContext application = new ClassPathXMLApplicationContext("com/example/webdemo/frame/ioc/ioc_demo.xml");
        StudentService studentService = (StudentService) application.getBean("StudentService");
        Student student = studentService.getStudent();
        String string = student.toString();
        String name = student.getName();
        String address = student.getAddress();
        log.info(string);
        log.info(name);
        log.info(address);

        Student stu = (Student) application.getBean("Student");
        stu.setName("xiaoming");
        stu.setAddress("beijing");
        log.info(stu.toString());
    }
}
