package com.example.webdemo.frame.ioc;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ContextTest {

    public static void main(String[] args) {
        ApplicationContext application = new ClassPathXMLApplicationContext("static/ioc/ioc_demo.xml");
        System.out.println(application);
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
