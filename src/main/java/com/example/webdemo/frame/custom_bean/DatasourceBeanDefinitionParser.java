package com.example.webdemo.frame.custom_bean;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class DatasourceBeanDefinitionParser implements BeanDefinitionParser {
    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {
        RootBeanDefinition def = new RootBeanDefinition();
        def.setBeanClass(DatasourceInfo.class);

        String id = element.getAttribute("id");
        String url = element.getAttribute("url");
        String userName = element.getAttribute("userName");
        String password = element.getAttribute("password");

        BeanDefinitionHolder idDefinitionHolder = new BeanDefinitionHolder(def, id);
        BeanDefinitionReaderUtils.registerBeanDefinition(idDefinitionHolder, parserContext.getRegistry());

        def.getPropertyValues().addPropertyValue("url", url);
        def.getPropertyValues().addPropertyValue("userName", userName);
        def.getPropertyValues().addPropertyValue("password", password);

        return def;
    }
}
