

package com.example.webdemo.validation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PostMapping("/hello/test")
    public Object test(Integer age, String name, @Validate(isForm = true) TestForm form){
        System.out.println("测试validation校验。");
        return name + ", 您好！ 年龄： " + age;
    }
}
