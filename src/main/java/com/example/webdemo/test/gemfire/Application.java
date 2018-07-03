///*
// *         File : Application.java
// *    Classname : Application
// *    Author(s) : eznlzhi
// *      Created : 2018-05-09
// *
// * Copyright (c) 2017 Ericsson AB, Sweden.
// * All rights reserved.
// * The Copyright to the computer program(s) herein is the property of
// * Ericsson AB, Sweden.
// * The program(s) may be used and/or copied with the written permission
// * from Ericsson AB or in accordance with the terms and conditions
// * stipulated in the agreement/contract under which the program(s)
// * have been supplied.
// *
// */
//
//package com.example.webdemo.test.gemfire;
//
//import org.apache.geode.cache.client.ClientRegionShortcut;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.data.gemfire.config.annotation.ClientCacheApplication;
//import org.springframework.data.gemfire.config.annotation.EnableEntityDefinedRegions;
//import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
//
//@SpringBootApplication
//@ClientCacheApplication(name = "AccessingGemFireDataRestApplication", logLevel = "error")
//@EnableEntityDefinedRegions(basePackageClasses = Person.class, clientRegionShortcut = ClientRegionShortcut.LOCAL)
//@EnableGemfireRepositories
//@SuppressWarnings("unused")
//public class Application {
//    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//    }
//}
