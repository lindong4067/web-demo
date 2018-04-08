/*
 *         File : Voltage220.java
 *    Classname : Voltage220
 *    Author(s) : eznlzhi
 *      Created : 2018-04-04
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

package com.example.webdemo.pattern.adapter._class;

public class Voltage220 {
    public int outPut220V(){
        int vol = 220;
        System.out.println("我是 " + vol + " V的。");
        return vol;
    }
}
