///*
// *         File : FmRmiServerUpdate.java
// *    Classname : FmRmiServerUpdate
// *    Author(s) : eznlzhi
// *      Created : 2018-02-27
// *
// * Copyright (c) 2017 Ericsson AB, Sweden.
// * All rights reserved.
// * The Copyright to the computer program(s) herein is the property of
// * Ericsson AB, Sweden.
// * The program(s) may be used and/or copied with the written permission
// * from Ericsson AB or in accordance with the terms and conditions
// * stipulated in the agreement/contract under which the program(s)
// * have been supplied.
// *
// */
//
//package com.example.webdemo.esa;
//
//import com.ericsson.esa.common.utils.ExtensionFilter;
//import com.ericsson.esa.common.xml.XmlUtils;
//import com.ericsson.esa.common.xml.schema.AlarmDefinitions;
//import com.ericsson.esa.fmagent.alarmservice.AlarmDefinition;
//import com.ericsson.esa.fmagent.alarmservice.AlarmDefinitionController;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.io.File;
//import java.rmi.RemoteException;
//import java.rmi.server.UnicastRemoteObject;
//import java.util.*;
//
//@Service
//@Slf4j
//public class AlarmServerUpdate {
//
//    private static final long serialVersionUID = 1L;
//
////    private static final String ALARM_DEFINITION_DIR = "/opt/ESA/ESA/conf/fmAlarmDefinitions";
//    private static final String ALARM_DEFINITION_DIR = "C:\\Temp\\xmltest";
//
//    public ResponseEntity updateAlarmDefinitions(List<AlarmDefinitionsRequest> alarmDefinitionRequest) {
//        boolean updateAlarmDefinition = updateAlarmDefinition(ALARM_DEFINITION_DIR, alarmDefinitionRequest);
//        return updateAlarmDefinition ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.BAD_REQUEST);
//    }
//
//    private boolean updateAlarmDefinition(String alarmDefinitionDir, List<AlarmDefinitionsRequest> alarmDefinitionRequest) {
//        //1.测试一下文件夹不存在和文件夹为空时的情况
//        File alarmDefinitionFile = new File(alarmDefinitionDir);
//        ExtensionFilter xmlFilter = new ExtensionFilter("xml");
//        File[] xmlFiles = alarmDefinitionFile.listFiles(xmlFilter);
//        if(xmlFiles == null){
//            return false;
//        }
//        for (File file : xmlFiles) {
//            log.info("Reading alarm definitions from file " + file.getName());
//            AlarmDefinitions xmlAlarmDefinitions = (AlarmDefinitions)XmlUtils.readXml(file.getAbsolutePath(), AlarmDefinitions.class);
//            List<AlarmDefinitions.AlarmSpecification> xmlAlarmSpecifications = xmlAlarmDefinitions.getAlarmSpecification();
//            if(xmlAlarmSpecifications.size() == 0){
//                return false;
//            }
//            for (AlarmDefinitionsRequest alarmDefinition : alarmDefinitionRequest) {
//                for (AlarmDefinitions.AlarmSpecification xmlAlarm : xmlAlarmSpecifications) {
//                    if(xmlAlarm.getModuleId().equalsIgnoreCase(alarmDefinition.getModuleId()) && (xmlAlarm.getErrorCode() == alarmDefinition.getErrorCode())){
//                        log.info("Find Specific AlarmDefinition {} in {}.", xmlAlarm, file);
//                        xmlAlarm.setActive(alarmDefinition.getActive());
//                        xmlAlarm.setSeverity(alarmDefinition.getSeverity());
//                    }
//                }
//            }
////            for (AlarmDefinitionsRequest alarmDefinition : alarmDefinitionRequest) {
////                for (AlarmDefinitions.AlarmSpecification xmlAlarm : xmlAlarmSpecifications) {
////                    if (xmlAlarm.getModuleId().equalsIgnoreCase(alarmDefinition.getModuleId()) && xmlAlarm.getErrorCode() == alarmDefinition.getErrorCode()) {
////                        log.info("GET Specific AlarmDefinition in {}.", xmlAlarm.getActive());
////                        log.info("GET Specific AlarmDefinition in {}.", xmlAlarm.getSeverity());
////                    }
////                }
////            }
//            try {
//                XmlUtils.writeXml(file.getAbsolutePath(), AlarmDefinitions.class, xmlAlarmDefinitions);
//            } catch (Exception e) {
//                log.error(e.getMessage());
//                return false;
//            }
//        }
//        return true;
//    }
//
//}
//
////                xmlAlarmSpecifications.forEach(e -> {
////                    if(e.getModuleId().equalsIgnoreCase(alarmDefinition.getModuleId()) && e.getErrorCode() == alarmDefinition.getErrorCode()){
////                        log.info("Find alarm definitions from file " + e);
////                        e.setActive(alarmDefinition.getAlarmActive() ? "yes" : "no");
////                        e.setSeverity(alarmDefinition.getSeverity());
////                        e.setModelDescription(alarmDefinition.getModelDescription());
////                        e.setActiveDescription(alarmDefinition.getActiveDescription());
////                        e.setEventType(alarmDefinition.getEventType());
////                        e.setProbableCause(alarmDefinition.getProbableCause());
////                        log.info("update alarm definitions from file " + alarmDefinition);
////                    }
////                });