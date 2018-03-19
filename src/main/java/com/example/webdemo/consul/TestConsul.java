/*
 *         File : TestConsul.java
 *    Classname : TestConsul
 *    Author(s) : EZNLZHI
 *      Created : 2018-03-15
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

package com.example.webdemo.consul;

//import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestConsul {
    public static final String ALARM_DEFINITION_PATH = "C:\\Temp\\xmltest";
    public static final String ESA_CONF_PATH = "C:\\Temp\\config";

//    public static final String ALARM_DEFINITION_PATH = "/opt/ESA/ESA/conf/fmAlarmDefinitions";
//    public static final String ESA_CONF_PATH = "/opt/ESA/ESA/conf";

    public static final String CONSUL_KEY_SMPC = "esa/cluster/config/smpc";
    public static final String CONSUL_KEY_GMPC = "esa/cluster/config/gmpc";
    public static final String CONSUL_KEY_HW = "esa/cluster/config/hw";

//    @Test
    public void testArray(){
        List<String> list1 = Arrays.asList("XXX", "YYY", "ZZZ");
        List<String> list2 = Arrays.asList("ZZZ", "YYY", "XXX");
        boolean contains = list1.contains(list2);
        boolean containsAll = list1.containsAll(list2);
        boolean containsAll2 = list2.containsAll(list1);
//        System.out.println(contains);
//        System.out.println(containsAll && containsAll2);
        boolean equals = list1.equals(list2);
//        System.out.println(equals);

        String[] str1 = new String[]{"XXX","YYY","ZZZ"};
//        String[] str2 = new String[]{"XXX","YYY","ZZZ"};
        String[] str2 = new String[]{"ZZZ","YYY","XXX"};
        Arrays.sort(str1);
        Arrays.sort(str2);
        boolean b = Arrays.deepEquals(str1, str2);
        boolean equals1 = Arrays.equals(str1, str2);
        System.out.println(b);
        System.out.println(equals1);
    }
}
