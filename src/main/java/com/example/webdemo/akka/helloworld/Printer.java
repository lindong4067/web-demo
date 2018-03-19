/*
 *         File : Printer.java
 *    Classname : Printer
 *    Author(s) : eznlzhi
 *      Created : 2018-03-06
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

package com.example.webdemo.akka.helloworld;

import akka.actor.AbstractActor;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Printer extends AbstractActor {

    private LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    public static Props props(){
        return Props.create(Printer.class, Printer::new);
    }

    public static class Greeting {
        public final String message;

        public Greeting(String message) {
            this.message = message;
        }
    }

    public Printer() {
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(Greeting.class, greeting -> log.info(greeting.message))
                .build();
    }
}
