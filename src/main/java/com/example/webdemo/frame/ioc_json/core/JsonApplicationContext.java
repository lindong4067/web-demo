package com.example.webdemo.frame.ioc_json.core;

import com.alibaba.fastjson.JSON;
import com.example.webdemo.frame.ioc_json.bean.BeanDefinition;
import com.example.webdemo.utils.FileUtil;

import java.net.URL;
import java.util.List;

public class JsonApplicationContext extends BeanFactoryImpl {

    private String fileName;

    public JsonApplicationContext(String fileName) {
        this.fileName = fileName;
    }

    public void init() {
        loadFile();
    }

    private void loadFile() {
        URL url = this.getClass().getClassLoader().getResource(fileName);
        String json = FileUtil.readeUrl(url);
        List<BeanDefinition> beanDefinitions = JSON.parseArray(json, BeanDefinition.class);
        if (beanDefinitions != null && !beanDefinitions.isEmpty()) {
            for (BeanDefinition beanDefinition : beanDefinitions) {
                registerBean(beanDefinition.getName(), beanDefinition);
            }
        }
    }
}
