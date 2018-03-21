/*
 *         File : IAlarmDefinition2.java
 *    Classname : IAlarmDefinition2
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

import com.ericsson.esa.fmagent.alarmservice.AlarmDefinition;
import org.springframework.http.ResponseEntity;

import java.rmi.RemoteException;
import java.util.Collection;

public interface IAlarmDefinitionUpdate {

    ResponseEntity updateAlarmDefinitions(Collection<AlarmDefinition> alarmDefinitions) throws RemoteException;
}
