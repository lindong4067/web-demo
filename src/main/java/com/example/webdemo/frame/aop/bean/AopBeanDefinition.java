

package com.example.webdemo.frame.aop.bean;

import com.example.webdemo.frame.ioc_json.bean.BeanDefinition;
import lombok.Data;

import java.util.List;

@Data
public class AopBeanDefinition extends BeanDefinition {
    private String target;
    private List<String> interceptorNames;
}
