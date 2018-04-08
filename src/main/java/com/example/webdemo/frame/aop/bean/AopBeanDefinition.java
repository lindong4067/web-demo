/*
 *         File : AopBeanDefinition.java
 *    Classname : AopBeanDefinition
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

package com.example.webdemo.frame.aop.bean;

import com.example.webdemo.frame.ioc_json.bean.BeanDefinition;
import lombok.Data;

import java.util.List;

@Data
public class AopBeanDefinition extends BeanDefinition {
    private String target;
    private List<String> interceptorNames;
}
