/*
 *         File : Company.java
 *    Classname : Company
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

import java.util.List;

public class Company {
    private List<Person> personList;

    @Override
    public String toString() {
        return "Company{" +
                "personList=" + personList +
                '}';
    }

    public Company(List<Person> personList) {
        this.personList = personList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
