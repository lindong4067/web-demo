/*
 *         File : WebController.java
 *    Classname : WebController
 *    Author(s) : eznlzhi
 *      Created : 2018-01-16
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

package com.example.webdemo.controller;

import com.example.webdemo.domain.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class WebController {

    @PostMapping("/hello")
    public Object test(@RequestBody User user, HttpServletRequest request, HttpServletResponse response) {
//        Assert.assertNotNull("Age not null", user.getAddress());
//        Assert.assertNotNull("Name not null", user.getName());

//        Address address = user.getAddress();
//        System.out.println("------");
//        String name = user.getName();
//        int age = user.getAge();
//        System.out.println(address);
//        System.out.println(name);
//        System.out.println(age);
//        System.out.println("------");
//        System.out.println(user.toString());
        return user;
    }
}
