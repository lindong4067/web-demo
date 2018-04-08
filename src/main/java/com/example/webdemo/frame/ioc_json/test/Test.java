/*
 *         File : Test.java
 *    Classname : Test
 *    Author(s) : eznlzhi
 *      Created : 2018-03-29
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

package com.example.webdemo.frame.ioc_json.test;

import com.example.webdemo.frame.ioc_json.core.JsonApplicationContext;

public class Test {
    public static void main(String[] args) throws Exception {
        JsonApplicationContext context = new JsonApplicationContext("C:\\Users\\EZNLZHI\\IdeaProjects\\web-demo\\src\\main\\java\\com\\example\\webdemo\\frame\\ioc_json\\test\\ioc.json");
        context.init();
        Robot robot = (Robot) context.getBean("robot");
        robot.show();
    }
}
