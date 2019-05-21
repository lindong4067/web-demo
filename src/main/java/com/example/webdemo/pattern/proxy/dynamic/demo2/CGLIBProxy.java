package com.example.webdemo.pattern.proxy.dynamic.demo2;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;


public class CGLIBProxy {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Angell.class);
        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            System.out.println("天使来了, " + method.getName());
            methodProxy.invokeSuper(o, objects);
            System.out.println("天使走了, " + method.getName());
            return o;
        });
        Angell angell = (Angell) enhancer.create();
        angell.protect();
        angell.save();
    }
}

class Angell {
    void save() {
        System.out.println("天使救人中...");
    }

    void protect() {
        System.out.println("天使保护中...");
    }
}

