package com.example.webdemo.frame.aophand;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HumanHandler implements InvocationHandler {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(method);
        Object returnValue = method.invoke(target, args);
        after(method);
        return returnValue;
    }

    private void before(Method method) {
        System.out.println("Before " + method.getName() + ", do something...");
    }

    private void after(Method method) {
        System.out.println("After " + method.getName() + ", do something...");
    }
}
