

package com.example.webdemo.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.Iterator;
import java.util.List;

@RestController
public class AlarmDefinitionController {

    public static final String ALARMPATH = "C:\\Temp\\xml\\alarmdefinition.xml";
    public static final String HWPATH = "C:\\Temp\\xml\\hw_alarmdef.xml";

    @RequestMapping(value = "/alarm_manager/alarms/alarm_list", method = RequestMethod.PUT)
    public @ResponseBody
    Object setActiveOrDeavtive(@RequestBody List<AlarmSpecification> alarmDefinition){
        File[] files = {new File(ALARMPATH), new File(HWPATH)};
        try {
            for (File file : files) {

                Document document = new SAXReader().read(file);
                Element rootElement = document.getRootElement();
                Iterator<Element> iterator = rootElement.elementIterator("alarmSpecification");
                while (iterator.hasNext()){
                    Element element = iterator.next();
                    for (AlarmSpecification alarmSpecification : alarmDefinition) {
                        if(alarmSpecification.getModuleId().equalsIgnoreCase(element.elementText("moduleId")) &&
                                alarmSpecification.getErrorCode() == Integer.parseInt(element.elementText("errorCode"))){
                            element.addAttribute("active",alarmSpecification.getActive());
                            element.element("severity").setText(String.valueOf(alarmSpecification.getSeverity()));
                            element.element("modelDescription").setText(alarmSpecification.getModelDescription());
                            element.element("activeDescription").setText(alarmSpecification.getActiveDescription());
                            element.element("eventType").setText(alarmSpecification.getEventType());
                            element.element("probableCause").setText(alarmSpecification.getProbableCause());
        //                        Element documentation = element.addElement("documentation");
        //                        documentation.addElement("description").setText(alarmSpecification.getDocumentation().getDescription());
        //                        documentation.addElement("alarmingObject").setText(alarmSpecification.getDocumentation().getAlarmingObject());
        //                        documentation.addElement("raisedBy").setText(alarmSpecification.getDocumentation().getRaisedBy());
        //                        documentation.addElement("clearedBy").setText(alarmSpecification.getDocumentation().getClearedBy());
        //                        documentation.addElement("proposedRepairAction").setText(alarmSpecification.getDocumentation().getProposedRepairAction());

                        }
                    }
                }

                FileOutputStream out = new FileOutputStream(file);
                OutputFormat format= OutputFormat.createPrettyPrint();
                format.setEncoding("UTF-8");
                XMLWriter writer = new XMLWriter(out, format);
                writer.write(document);
                writer.close();
//
            }
            return new ResponseEntity(HttpStatus.OK);
        } catch (DocumentException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
