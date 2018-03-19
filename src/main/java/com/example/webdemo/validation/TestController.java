/*
 *         File : TestController.java
 *    Classname : TestController
 *    Author(s) : eznlzhi
 *      Created : 2018-02-01
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
