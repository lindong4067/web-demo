

package com.example.webdemo.frame.ioc;

import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;

@Slf4j
public class ContextTest {
    //    @Test
    public void test() {
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
