/*
 *         File : JsonUtils.java
 *    Classname : JsonUtils
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

package com.example.webdemo.frame.ioc_json.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.webdemo.frame.ioc_json.bean.BeanDefinition;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class JsonUtils {
    public static List<BeanDefinition> readValue(InputStream inputStream, TypeReference<List<BeanDefinition>> typeReference) {
        try {
            return JSON.parseObject(inputStream, (Type) typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
