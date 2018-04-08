/*
 *         File : ReflectionUtils.java
 *    Classname : ReflectionUtils
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

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

@Slf4j
public class ReflectionUtils {

    public static void injectField(Field field, Object obj, Object value){
        if(field != null){
            try {
                field.setAccessible(true);
                field.set(obj, value);
            } catch (IllegalAccessException e) {
                log.error(e.getMessage());
            }
        }
    }
}
