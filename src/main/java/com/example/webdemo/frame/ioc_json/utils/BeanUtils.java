/*
 *         File : BeanUtils.java
 *    Classname : BeanUtils
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


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

public class BeanUtils {
    public static <T> T instanceByCglib(Class<T> clz, Constructor ctr, Object[] args){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clz);
        enhancer.setCallback(NoOp.INSTANCE);
        if(ctr == null){
            return (T) enhancer.create();
        }else{
            return (T) enhancer.create(ctr.getParameterTypes(), args);
        }
    }
}
