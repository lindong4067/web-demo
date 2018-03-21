/*
 *         File : AlarmDefinitionsUpdate.java
 *    Classname : AlarmDefinitionsUpdate
 *    Author(s) : eznlzhi
 *      Created : 2018-02-28
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

import com.ericsson.esa.common.xml.schema.AlarmDefinitions;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "",
    propOrder = {"alarmSpecification"}
)
@XmlRootElement(
    name = "alarmDefinitions",
    namespace = "http://www.ericsson.com/esa"
)
public class AlarmDefinitionsUpdate implements Serializable {

    @XmlElement(
        namespace = "http://www.ericsson.com/esa",
        required = true
    )
    private List<AlarmDefinitions.AlarmSpecification> alarmSpecification;

    public AlarmDefinitionsUpdate(List<AlarmDefinitions.AlarmSpecification> alarmSpecification) {
        this.alarmSpecification = alarmSpecification;
    }

    public AlarmDefinitionsUpdate() {
    }

    public List<AlarmDefinitions.AlarmSpecification> getAlarmSpecification() {
        return alarmSpecification;
    }

    public void setAlarmSpecification(List<AlarmDefinitions.AlarmSpecification> alarmSpecification) {
        this.alarmSpecification = alarmSpecification;
    }

}
