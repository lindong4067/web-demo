package com.example.webdemo.frame.ioc_json.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.example.webdemo.frame.ioc_json.bean.BeanDefinition;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class JsonUtils {
    public static List<BeanDefinition> readValue(InputStream inputStream, TypeReference<List<BeanDefinition>> typeReference) {
        try {
            return JSON.parseObject(inputStream, (Type) typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
