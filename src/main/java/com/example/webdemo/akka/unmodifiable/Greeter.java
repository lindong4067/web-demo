/*
 *         File : Greeter.java
 *    Classname : Greeter
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

import akka.actor.UntypedAbstractActor;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Greeter extends UntypedAbstractActor {
    @Override
    public void onReceive(Object message) throws Throwable {
        log.info("Greeter收到数据为: \n{}", JSONObject.toJSONString(message));
        getSender().tell("Greeter工作完成.", getSelf());
    }
}
