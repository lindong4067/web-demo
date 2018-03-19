/*
 *         File : AspectJTest.java
 *    Classname : AspectJTest
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

package com.example.webdemo.domain.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectJTest {

    @Pointcut("execution(* *.test(..))")
    public void test(){

    }

    @Before("test()")
    public void beforeTest(){
        System.out.println("前置通知消息。");
    }

    @After("test()")
    public void afterTest(){
        System.out.println("后置通知消息。");
    }

    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint point){
        System.out.println("环绕通知前消息。");
        Object object = null;
        try {
            object = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕通知后消息。");
        return object;
    }
}
