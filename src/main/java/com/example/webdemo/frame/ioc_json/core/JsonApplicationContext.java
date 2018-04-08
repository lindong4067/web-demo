/*
 *         File : JsonApplicationContext.java
 *    Classname : JsonApplicationContext
 *    Author(s) : eznlzhi
 *      Created : 2018-03-28
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

package com.example.webdemo.frame.ioc_json.core;

import com.alibaba.fastjson.JSON;
import com.example.webdemo.frame.ioc_json.bean.BeanDefinition;
import com.example.webdemo.utils.FileUtil;

import java.util.List;

public class JsonApplicationContext extends BeanFactoryImpl {

    private String fileName;

    public JsonApplicationContext(String fileName) {
        this.fileName = fileName;
    }

    public void init(){
        loadFile();
    }

    private void loadFile() {
        String json = FileUtil.readerFile(fileName);
        List<BeanDefinition> beanDefinitions = JSON.parseArray(json, BeanDefinition.class);
        if(beanDefinitions != null && !beanDefinitions.isEmpty()){
            for (BeanDefinition beanDefinition : beanDefinitions) {
                registerBean(beanDefinition.getName(), beanDefinition);
            }
        }
    }
}
