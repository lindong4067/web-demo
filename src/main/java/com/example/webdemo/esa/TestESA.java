/*
 *         File : TestESA.java
 *    Classname : TestESA
 *    Author(s) : eznlzhi
 *      Created : 2018-02-27
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

package com.example.webdemo.esa;

import com.ericsson.esa.common.Constants;
import com.ericsson.esa.fmagent.alarmservice.AlarmDefinition;
import com.ericsson.esa.fmagent.rmi.IAlarmDefinition;
import com.example.webdemo.utils.FileUtil;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class TestESA {

    private static Log log = LogFactory.getLog(TestESA.class);

    private static IAlarmDefinition alarmDefApi = null;

    private static void setupRMIConnection() {
        String host = "127.0.0.1";
        int rmiPort = 8666;

        try {
            alarmDefApi = (IAlarmDefinition) Naming.lookup("//" + host + ":" + rmiPort + "/" + Constants.FM_ALARM_DEFINITION_RMI_NAME);
        } catch (MalformedURLException e) {
            log.error(e.getMessage());
        } catch (NotBoundException e) {
            log.error(e.getMessage());
        } catch (RemoteException e) {
            log.error(e.getMessage());
        }
    }

    public void Test() {
        setupRMIConnection();
        try {
            Collection<AlarmDefinition> alarmDefinitions = alarmDefApi.getAlarmDefinitions();
            boolean hw = alarmDefApi.isAlarmDefinition("HW", 140601);
            boolean hw1 = alarmDefApi.isAlarmDefinitionActive("HW", 140601);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    //    @Test
//    正则如何匹配指定字符后面出现的正则匹配内容
    /*
     *
     */
    public void cluster() {
        String file = FileUtil.readerFile("C:\\Temp\\config\\cluster.conf");

        String fmRegex = "seed-nodes=[\\s\\S]*FM[\\s\\S]*?]";
        String maRegex = "seed-nodes=[\\s\\S]*MA[\\s\\S]*?]";

        List<String> ips = new ArrayList<>();
        ips.add("127.0.0.1");
        ips.add("127.0.0.2");
        ips.add("127.0.0.3");

        String fmNodes = "seed-nodes=[";
        for (String ip : ips) {
            String node = String.format("\"akka.tcp://FMCluster@%s:2551\",", ip);
            fmNodes = fmNodes + node;
        }
        fmNodes = fmNodes.substring(0, fmNodes.length() - 1);
        fmNodes = fmNodes + "]";
        file = file.replaceAll(fmRegex, fmNodes);

        String maNodes = "seed-nodes=[";
        for (String ip : ips) {
            String node = String.format("\"akka.tcp://MACluster@%s:2552\",", ip);
            maNodes = maNodes + node;
        }
        maNodes = maNodes.substring(0, maNodes.length() - 1);
        maNodes = maNodes + "]";
        file = file.replaceAll(maRegex, maNodes);

        System.out.println(file);
    }

//    @Test
    public void cluster2() {
        String file = FileUtil.readerFile("C:\\Temp\\config\\cluster.conf");

        List<String> ips = new ArrayList<>();
        ips.add("127.0.0.1");
        ips.add("127.0.0.2");
        ips.add("127.0.0.3");

        String fmNodes = "";
        for (String ip : ips) {
            String node = String.format("\"akka.tcp://FMCluster@%s:2551\",", ip);
            fmNodes = fmNodes + node;
        }
        fmNodes = fmNodes.substring(0, fmNodes.length() - 1);

        String maNodes = "";
        for (String ip : ips) {
            String node = String.format("\"akka.tcp://MACluster@%s:2552\",", ip);
            maNodes = maNodes + node;
        }
        maNodes = maNodes.substring(0, maNodes.length() - 1);

        String[] strings = StringUtils.substringsBetween(file, "[", "]");
        file = file.replace(strings[0], fmNodes);
        file = file.replace(strings[3], maNodes);

        System.out.println(file);
    }
}
