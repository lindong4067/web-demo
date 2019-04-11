package com.example.webdemo.frame.ioc_json.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    public static Class loadClass(String className) {
        try {
            return getDefaultClassLoader().loadClass(className);
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage());
        }
        return null;
    }
}
