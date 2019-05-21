/*
 *         File : MessagePrinter.java
 *    Classname : MessagePrinter
 *    Author(s) : eznlzhi
 *      Created : 2018-05-08
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

package com.example.webdemo.test.hello;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

    final private MessageService service;

    public MessagePrinter(@Qualifier("mockMessageService") MessageService service) {
        this.service = service;
    }

    public void printMessage() {
        System.out.println(this.service.getMessage());
    }
}
