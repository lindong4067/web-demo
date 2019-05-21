package com.example.webdemo.pattern.proxy.dynamic.demo2;

import java.lang.reflect.Proxy;

public class JDKProxy {
    public static void main(String[] args) {
        Person proxy = new ActorProxy(new Actor()).getProxy();
        proxy.sing();
        proxy.dance();
    }
}

interface Person {
    void sing();
    void dance();
}

class Actor implements Person {

    @Override
    public void sing() {
        System.out.println("唱支山歌给党听~~~");
    }

    @Override
    public void dance() {
        System.out.println("前进，前进，前进~~~");
    }
}

class ActorProxy {
    private Actor actor;

    public ActorProxy(Actor actor) {
        this.actor = actor;
    }

    Person getProxy(){
        return (Person) Proxy.newProxyInstance(
                actor.getClass().getClassLoader(),
                actor.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    if ("sing".equals(method.getName())) {
                        System.out.println("准备麦克风");
                    }
                    if ("dance".equals(method.getName())) {
                        System.out.println("准备舞台");
                    }
                    return method.invoke(actor, args);
                });
    }
}