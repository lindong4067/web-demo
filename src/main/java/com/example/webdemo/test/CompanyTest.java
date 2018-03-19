/*
 *         File : CompanyTest.java
 *    Classname : CompanyTest
 *    Author(s) : eznlzhi
 *      Created : 2018-03-12
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

package com.example.webdemo.test;

import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CompanyTest {
//    @Test
    public void test(){
        Person p1 = new Person(1, "aaa");
        Person p2 = new Person(2, "bbb");
        Person p3 = new Person(3, "ccc");
        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);

        Company company = new Company(personList);

        log.info(company.toString());

        for (Person person : personList) {
            log.info(person.toString());
        }
        for (Person person : personList) {
            person.setId(4);
            person.setName("ddd");
        }
        for (Person person : personList) {
            log.info(person.toString());
        }
        log.info(company.toString());
    }
}
