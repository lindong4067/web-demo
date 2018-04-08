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

package com.example.webdemo.pattern.adapter._object;

import com.example.webdemo.pattern.adapter._class.Voltage220;
import com.example.webdemo.pattern.adapter._class.Voltage5;

public class VoltageAdapter implements Voltage5 {
    private Voltage220 voltage220;
    public VoltageAdapter(Voltage220 voltage220) {
        this.voltage220 = voltage220;
    }

    @Override
    public int outPut5V() {
        int V5 = 0;
        if (voltage220 != null) {
            int V220 = voltage220.outPut220V();
            V5 = V220 / 44;
        }
        return V5;
    }

    public static void main(String[] args) {
        VoltageAdapter volt = new VoltageAdapter(new Voltage220());
        int put5V = volt.outPut5V();
        System.out.println("输出电压: " + put5V + "V");
    }
}
