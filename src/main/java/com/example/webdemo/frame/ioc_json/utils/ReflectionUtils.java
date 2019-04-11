package com.example.webdemo.frame.ioc_json.utils;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

@Slf4j
public class ReflectionUtils {

    public static void injectField(Field field, Object obj, Object value) {
        if (field != null) {
            try {
                field.setAccessible(true);
                field.set(obj, value);
            } catch (IllegalAccessException e) {
                log.error(e.getMessage());
            }
        }
    }
}
