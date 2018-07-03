

package com.example.webdemo.frame.ioc;

import lombok.extern.slf4j.Slf4j;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Slf4j
public class ClassPathXMLApplicationContext implements ApplicationContext {
    private File file;
    private Map map = new HashMap();

    public ClassPathXMLApplicationContext(String configFile) {
        URL url = this.getClass().getClassLoader().getResource(configFile);
//        URL url = this.getClass().getClassLoader().getResource(configFile);
        log.info(url == null ? "Null" : "Not Null");
        try {
            if (url != null) {
                file = new File(url.toURI());
                XMLParsing();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    private void XMLParsing() throws JDOMException, IOException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build(file);
        XPath xPath = XPath.newInstance("//bean");
        List beans = xPath.selectNodes(doc);
        Iterator i = beans.iterator();
        while (i.hasNext()) {
            Element bean = (Element) i.next();
            String id = bean.getAttributeValue("id");
            String cls = bean.getAttributeValue("class");
            Object obj = Class.forName(cls).newInstance();
            Method[] method = obj.getClass().getDeclaredMethods();
            List<Element> list = bean.getChildren("property");
            for (Element el : list) {
                for (int n = 0; n < method.length; n++) {
                    String name = method[n].getName();
                    String temp = null;
                    if (name.startsWith("set")) {
                        temp = name.substring(3, name.length()).toLowerCase();
                        if (el.getAttribute("name") != null) {
                            if (temp.equals(el.getAttribute("name").getValue())) {
                                method[n].invoke(obj, el.getAttribute("value").getValue());
                            }
                        } else {
                            Object ref = map.get(el.getAttribute("ref").getValue());
                            log.info("Get from map : ", ref);
                            method[n].invoke(obj, ref);
                        }
                    }
                }
            }
            map.put(id, obj);
            log.info("Put in map : ", id);
        }
    }

    public Object getBean(String name) {
        return map.get(name);
    }
}
