/*
 *         File : VoltageAdapter.java
 *    Classname : VoltageAdapter
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

public class VoltageAdapter extends Voltage220 implements Voltage5 {
    @Override
    public int outPut5V() {
        int src = outPut220V();
        System.out.println("适配器工作开始适配电压");
        int dst = src / 44;
        System.out.println("适配完成后输出电压：" + dst);
        return dst;
    }
}
