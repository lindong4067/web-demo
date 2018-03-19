/*
 *         File : FileTest.java
 *    Classname : FileTest
 *    Author(s) : eznlzhi
 *      Created : 2018-03-06
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

import com.example.webdemo.utils.FileUtil;
//import org.junit.Assert;
//import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class FileTest {

//    @Test
    public void test(){
        String insertContent = "\n\t\t\t\t\"akka.tcp://FMCluster@10.180.160.33:2551\",";
        boolean insert = FileUtil.insert("C:\\Temp\\config\\cluster.conf", 491, insertContent);
//        Assert.assertTrue(insert);
    }

//    @Test
    public void test2(){
        String file = FileUtil.readerFile("C:\\Temp\\config\\cluster.conf");
        int length = file.length();
        System.out.println("File Length : " + length);
        int i = file.indexOf("[");
        System.out.println("[ index : " + i);
//        System.out.println(file);
    }

//  insert in specific position.
//    @Test
    public void test3(){
        String insertContent = "\n\t\t\t\t\"akka.tcp://FMCluster@10.180.160.33:2551\",";
        String insertContent2 = "\n\t\t\t\t\"akka.tcp://MACluster@192.168.0.1:2552\",";
        String fileName = "C:\\Temp\\config\\cluster.conf";
        String file = FileUtil.readerFile(fileName);
        int length = file.length();
        System.out.println("File length " + length);
        int i = file.indexOf("seed-nodes=[");
        System.out.println("First \"seed-nodes=[\" in " + i);
        List<Integer> index = getIndexList(file, "seed-nodes=[");
        int j = 1;
        for (Integer integer : index) {
            System.out.println("第" + j++ + "个 \"seed-nodes=[\" 下标为： " + integer);
        }
        boolean insert = FileUtil.insert(fileName, index.get(0) + 12, insertContent);
//        Assert.assertTrue(insert);

        String file1 = FileUtil.readerFile(fileName);
        List<Integer> index1 = getIndexList(file1, "seed-nodes=[");
        int k = 1;
        for (Integer integer : index1) {
            System.out.println("第" + k++ + "个 \"seed-nodes=[\" 下标为： " + integer);
        }
        boolean insert2 = FileUtil.insert(fileName, index1.get(1) + 12, insertContent2);
//        Assert.assertTrue(insert2);
    }

    public static List<Integer> getIndexList(String strings, String str){
        List<Integer> list = new ArrayList<>();
        int flag = 0;
        while (strings.contains(str)){
            String aa = strings.substring(0,strings.indexOf(str)+str.length());
            flag = flag + aa.length();
            list.add(flag - str.length());
            strings = strings.substring(strings.indexOf(str)+str.length());
        }
        return list;
    }
}
