
//
//package com.example.webdemo.esa;
//
//import com.ericsson.esa.common.xml.schema.AlarmDefinitions;
//
//import javax.xml.bind.annotation.*;
//import java.io.Serializable;
//import java.util.List;
//
//@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(
//    name = "",
//    propOrder = {"alarmSpecification"}
//)
//@XmlRootElement(
//    name = "alarmDefinitions",
//    namespace = "http://www.ericsson.com/esa"
//)
//public class AlarmDefinitionsUpdate implements Serializable {
//
//    @XmlElement(
//        namespace = "http://www.ericsson.com/esa",
//        required = true
//    )
//    private List<AlarmDefinitions.AlarmSpecification> alarmSpecification;
//
//    public AlarmDefinitionsUpdate(List<AlarmDefinitions.AlarmSpecification> alarmSpecification) {
//        this.alarmSpecification = alarmSpecification;
//    }
//
//    public AlarmDefinitionsUpdate() {
//    }
//
//    public List<AlarmDefinitions.AlarmSpecification> getAlarmSpecification() {
//        return alarmSpecification;
//    }
//
//    public void setAlarmSpecification(List<AlarmDefinitions.AlarmSpecification> alarmSpecification) {
//        this.alarmSpecification = alarmSpecification;
//    }
//
//}
