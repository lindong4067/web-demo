/*
 *         File : Hand.java
 *    Classname : Hand
 *    Author(s) : eznlzhi
 *      Created : 2018-03-29
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

package com.example.webdemo.frame.ioc_json.test;

import lombok.Data;

@Data
public class Hand {
    private String name;
    public void waveHand(){
        System.out.println("Wave Hand ... " + name);
    }
}
