/*
 *         File : Message.java
 *    Classname : Message
 *    Author(s) : eznlzhi
 *      Created : 2018-03-09
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

package com.example.webdemo.akka.unmodifiable;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public final class Message {

    private final int age;
    private final List<String> list;

    public Message(int age, List<String> list) {
        this.age = age;
        this.list = Collections.unmodifiableList(list);
    }


}
