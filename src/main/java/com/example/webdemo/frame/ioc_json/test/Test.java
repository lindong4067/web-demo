package com.example.webdemo.frame.ioc_json.test;

import com.example.webdemo.frame.ioc_json.core.JsonApplicationContext;

public class Test {
    public static void main(String[] args) throws Exception {
        JsonApplicationContext context = new JsonApplicationContext("static/ioc/ioc.json");
        context.init();
        Robot robot = (Robot) context.getBean("robot");
        robot.show();
    }
}
