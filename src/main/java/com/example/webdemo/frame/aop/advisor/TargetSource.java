

package com.example.webdemo.frame.aop.advisor;

import lombok.Data;

@Data
public class TargetSource {
    private Class<?> targetClass;
    private Object targetObject;
}
