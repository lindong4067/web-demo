

package com.example.webdemo.frame.ioc_json.bean;

import lombok.Data;

import java.util.List;

@Data
public class BeanDefinition {
    private String name;
    private String className;
    private String interfaceName;
    private List<ConstructorArg> constructorArgs;//构造函数参数列表
    private List<PropertyArg> propertyArgs;//需要注入的参数列表
}
