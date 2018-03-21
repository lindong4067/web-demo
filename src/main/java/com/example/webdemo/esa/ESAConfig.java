/*
 *         File : ESAConfigSchedule.java
 *    Classname : ESAConfigSchedule
 *    Author(s) : eznlzhi
 *      Created : 2018-03-07
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

import com.example.webdemo.utils.ConsulUtil;
import com.example.webdemo.utils.FileUtil;
import com.orbitz.consul.model.agent.Member;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

//@Component
@Slf4j
public class ESAConfig {

    @Scheduled(cron = "0/10 * * * * ?")
    public static void clusterAutoConfig() {
        List<Member> members = ConsulUtil.getConsulMembers();
        log.info("Load config from consul agent.");
        if (members == null) {
            return;
        }
//        String fileName = "/opt/ESA/ESA/conf/cluster.conf";
        String fileName = "C:\\Temp\\config\\cluster.conf";
        if (!FileUtil.checkFileExist(fileName)) {
            return;
        }
        log.info("Consul Members number : " + members.size());
        for (Member member : members) {
            String file = FileUtil.readerFile(fileName);
            String address = member.getAddress();
            String keyWordsFm = String.format("akka.tcp://FMCluster@%s:2551", address);
            String keyWordsMa = String.format("akka.tcp://MACluster@%s:2552", address);
            if (file.contains(keyWordsFm) && file.contains(keyWordsMa)) {
                continue;
            }
            if (StringUtils.isEmpty(file)) {
                log.info("Can't find ESA cluster config : {}.", fileName);
                continue;
            }
            if (!file.contains(keyWordsFm)) {
                log.info("Consul Agent {} is not in FmAgent cluster profile.", address);
                String insertContentFm = String.format("\n\t\t\"akka.tcp://FMCluster@%s:2551\",", address);
                List<Integer> index = FileUtil.getIndexList(file, "seed-nodes=[");
                FileUtil.insert(fileName, index.get(0) + 12, insertContentFm);
                log.info("Consul Agent {} is insert into FmAgent cluster profile.", address);
                file = FileUtil.readerFile(fileName);
            }
            if (!file.contains(keyWordsMa)) {
                log.info("Consul Agent {} is not in MasterAgent cluster profile.", address);
                String insertContentMa = String.format("\n\t\t\"akka.tcp://MACluster@%s:2552\",", address);
                String fileNew = FileUtil.readerFile(fileName);
                List<Integer> indexNew = FileUtil.getIndexList(fileNew, "seed-nodes=[");
                FileUtil.insert(fileName, indexNew.get(1) + 12, insertContentMa);
                log.info("Consul Agent {} is insert into MasterAgent cluster profile.", address);
            }

        }
        String file = FileUtil.readerFile(fileName);
        String localhost = null;
        try {
            localhost = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.error(e.getMessage());
        }
        String target = "hostname=\"\\d+.\\d+.\\d+.\\d+\"";
        String hostname = String.format("hostname=\"%s\"", localhost);
        if (!file.contains(hostname)) {
            String replaceFile = file.replaceAll(target, hostname);
            FileUtil.writeFileCover(replaceFile, fileName);
        }
    }
}
