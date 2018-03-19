/*
 *         File : StringTest.java
 *    Classname : StringTest
 *    Author(s) : eznlzhi
 *      Created : 2018-01-29
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

package com.example.webdemo.test;



//import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class StringTest {

//    @Test
    public void sub(){
        String msc = "1234";
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= msc.length(); i++) {
            String substr = msc.substring(0, i);
            list.add(substr);
        }
        System.out.println(list);
    }

//    @Test
    public void file(){
        String fileName = "a/b/c/test.txt";
        if(fileName.startsWith("/") || fileName.startsWith("\\")){
            System.out.println(fileName);
        }
        System.out.println("~~~~~~");
    }

//    @Test
    public void fileName(){
        String fileName = "/a/b/c/test.txt";
        String substring = fileName.substring(0, fileName.lastIndexOf("/"));
        System.out.println(substring);
    }

//    @Test
    public void nulltest(){
        String fileName = "/a/b/c/test.txt";
        String substring = fileName.substring(0, fileName.lastIndexOf("/"));
        System.out.println(substring);
    }

//    @Test
    public void foreachtest(){
        List<String> strings = new ArrayList<>();
        strings.add("abc");
        strings.add("qwe");
        strings.add("dfg");
        strings.add("bnm");
        for (String string : strings) {
            if (string.equalsIgnoreCase("bnm")){
                //for循环之间不能操作
                string = "1111";
            }
        }
        System.out.println(strings);
    }

//    @Test
    public void strlengthtest(){
        String str = "WE_";
        int length = str.length();

        System.out.println(length);
    }

//    @Test
    public void regxtest(){
        String moduleId = "HWaa89-_/@.";
        String number = "13";
        boolean matches = moduleId.matches("([a-zA-Z0-9]|-|_|/|@|\\.)*");
        boolean matches1 = number.matches("\\d+");
        System.out.println(matches1);
    }

//    @Test
//    replaceAll支持正则匹配,replace不支持
    public void regxtest2(){
        String target = "\nhostname=\"127.10.10.11\"\n";
        System.out.println(target);
        System.out.println(target.replaceAll("hostname=\"\\d+.\\d+.\\d+.\\d+\"", "hostname=\"127.0.0.1\""));

    }
}
