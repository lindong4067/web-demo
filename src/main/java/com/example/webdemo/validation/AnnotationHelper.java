/*
 *         File : AnnotationHelper.java
 *    Classname : AnnotationHelper
 *    Author(s) : eznlzhi
 *      Created : 2018-01-30
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

package com.example.webdemo.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class AnnotationHelper {

    public static List<Param> getParams(Method method, Object[] args) {
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        Class<?>[] parameterTypes = method.getParameterTypes();
        List<Param> params = new ArrayList<>();
        for(int i=0;i<parameterAnnotations.length;i++){
            for(int j=0;j<parameterAnnotations[i].length;j++){
                //如果出现指定的注解类型
                if(parameterAnnotations[i][j].annotationType() == Validate.class){
                    Param param = new Param(parameterTypes[i].getSimpleName(),
                            parameterTypes[i].getName(),//名称
                            parameterTypes[i],//参数类型
                            args[i],//参数值
                            parameterAnnotations[i][j]);//筛选出的注解
                    params.add(param);
                }
            }
        }
        return params;
    }
}
