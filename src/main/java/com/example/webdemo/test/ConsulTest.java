/*
 *         File : ConsulTest.java
 *    Classname : ConsulTest
 *    Author(s) : eznlzhi
 *      Created : 2018-03-09
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

import com.example.webdemo.utils.ConsulUtil;
import com.example.webdemo.utils.FileUtil;
import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;

@Slf4j
public class ConsulTest {

    public String fileName = "C:\\Temp\\config\\SMPC_alarmdefinition.xml";
    public String filePath = "C:\\Temp\\config\\SMPC_alarmdefinition_copy.xml";

//    @Test
    public void test1(){
        boolean b = ConsulUtil.putKV("/a/b/c", "com.example.webdemo.consul.ConsulController");
        log.info("保存结果：{}", b);
        String kv = ConsulUtil.getKV("/a/b/c/");
        log.info("Value:{}", kv);
    }

//    @Test
    public void test2(){
        String file = FileUtil.readerFile(fileName);

        boolean b = ConsulUtil.putKV("/a/b/c", file);
        log.info("保存结果：{}", b);
        String kv = ConsulUtil.getKV("/a/b/c");
        log.info("Value : ");
        log.info(kv);
        boolean b1 = FileUtil.writeFileCover(kv, filePath);
        log.info("写出结果:{}", b1);
    }
}
