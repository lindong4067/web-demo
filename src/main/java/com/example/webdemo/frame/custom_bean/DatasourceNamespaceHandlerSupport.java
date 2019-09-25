package com.example.webdemo.frame.custom_bean;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class DatasourceNamespaceHandlerSupport extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("datasource", new DatasourceBeanDefinitionParser());
    }
}
