///*
// *         File : Person.java
// *    Classname : Person
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
//import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.PersistenceConstructor;
//import org.springframework.data.gemfire.mapping.annotation.Region;
//
//import java.util.concurrent.atomic.AtomicLong;
//
//@Data
//@Region("People")
//public class Person {
//
//    private static AtomicLong COUNTER = new AtomicLong(0L);
//
//    @Id
//    private Long id;
//
//    private String firstName;
//    private String lastName;
//
//    @PersistenceConstructor
//    public Person() {
//        this.id = COUNTER.incrementAndGet();
//    }
//}
