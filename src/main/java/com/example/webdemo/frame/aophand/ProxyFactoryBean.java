package com.example.webdemo.frame.aophand;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactoryBean {
    private Object target;
    private InvocationHandler invocationHandler;

    public ProxyFactoryBean(Object target, InvocationHandler invocationHandler) {
        this.target = target;
        this.invocationHandler = invocationHandler;
    }

    public Object getProxyBean() {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                invocationHandler
        );
    }
}
