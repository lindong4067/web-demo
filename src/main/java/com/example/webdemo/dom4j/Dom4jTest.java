/*
 *         File : Dom4jTest.java
 *    Classname : Dom4jTest
 *    Author(s) : eznlzhi
 *      Created : 2018-02-24
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

package com.example.webdemo.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.*;
import java.util.Iterator;

public class Dom4jTest {

//    @Test
    public void writeDemo1() throws DocumentException, IOException {
        Document document = new SAXReader().read(new File("src/GMPC_alarmdefinition.xml"));
        FileOutputStream fos = new FileOutputStream("C:\\Temp\\xml\\alarmdefinition.xml");
        XMLWriter writer = new XMLWriter(fos);
        writer.write(document);
        writer.close();
    }

//    @Test
    public void updateDemo() throws DocumentException, IOException {
        Document doc = new SAXReader().read(new File("C:\\Temp\\xml\\alarmdefinition.xml"));
        Element rootElement = doc.getRootElement();
        Iterator<Element> iterator = rootElement.elementIterator("alarmSpecification");
        int i = 1;
        int j = 1;
        while (iterator.hasNext()){
            Element element = iterator.next();
            if("yes".equalsIgnoreCase(element.attributeValue("active"))){
                System.out.println("i - " + i++);
                if("RequestMonitor".equalsIgnoreCase(element.elementText("moduleId")) && "621".equalsIgnoreCase(element.elementText("errorCode"))){
                    System.out.println("j - " + j++);
                    element.addAttribute("active","no");
                    element.element("severity").setText("0");
                    element.element("activeDescription").setText("Hello Alarm !");
                }
            }

        }
        FileOutputStream out =new FileOutputStream("C:\\Temp\\xml\\alarmdefinition.xml");
        OutputFormat format= OutputFormat.createPrettyPrint();
        format.setEncoding("UTF-8");
        XMLWriter writer = new XMLWriter(out, format);
        writer.write(doc);
        writer.close();
    }
}
