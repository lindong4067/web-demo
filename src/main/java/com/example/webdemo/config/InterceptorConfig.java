/*
 *         File : InterceptorConfig.java
 *    Classname : InterceptorConfig
 *    Author(s) : eznlzhi
 *      Created : 2018-05-03
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

package com.example.webdemo.config;


import com.example.webdemo.interceptor.HeaderParamsCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    private final HeaderParamsCheckInterceptor headerParamsCheckInterceptor;

    @Autowired
    public InterceptorConfig(HeaderParamsCheckInterceptor headerParamsCheckInterceptor) {
        this.headerParamsCheckInterceptor = headerParamsCheckInterceptor;
    }

//    @Bean
//    public HeaderParamsCheckInterceptor getHeaderParamsCheckInterceptor(){
//        return new HeaderParamsCheckInterceptor();
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(headerParamsCheckInterceptor).addPathPatterns("/*");

    }
}
