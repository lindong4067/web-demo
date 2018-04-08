/*
 *         File : AccessibleTest.java
 *    Classname : AccessibleTest
 *    Author(s) : eznlzhi
 *      Created : 2018-04-04
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

package com.example.webdemo.frame.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * method.setAccessible(true)
 * 可以使private的方法被调用
 * 可以使private的属性被访问和修改
 */
public class AccessibleTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, NoSuchFieldException, InvocationTargetException {
        String className = "com.example.webdemo.frame.reflect.A";
        Class<?> c = Class.forName(className);
        Object o = c.newInstance();

        Method method = c.getDeclaredMethod("getInfo");

        Field field = c.getDeclaredField("info");

        method.setAccessible(true);
        method.invoke(o);

        field.setAccessible(true);
        field.set(o, 10);
        method.invoke(o);

        Method[] methods = c.getDeclaredMethods();
        for (Method method1 : methods) {
            String name = method1.getName();
            System.out.println(name);
        }
        Field[] fields = c.getDeclaredFields();
        for (Field field1 : fields) {
            String name = field1.getName();
            System.out.println(name);
        }
    }
}

class A{
    private int info;
    private int age;
    private int getInfo(){
        System.out.println("info = " + info);
        return info;
    }
    private int getAge(){
        System.out.println("age = " + age);
        return age;
    }
}
