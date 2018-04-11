

package com.example.webdemo.pattern.proxy.subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicProxy implements InvocationHandler{
    //被代理的真实对象
    private Object subject;
    //构造方法注入被代理对象
    public DynamicProxy(Object subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before rent house");
        System.out.println("Method: " + method);
        //当代理对象调用目标对象的方法时，会自动跳转到
        //代理对象关联的handler对象的invoke方法进行调用
        method.invoke(subject, args);
        System.out.println("After rent house");
        return null;
    }
}
