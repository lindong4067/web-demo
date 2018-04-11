

package com.example.webdemo.pattern.proxy.subject;

import com.example.webdemo.pattern.proxy.subject.Subject;

public class RealSubject implements Subject {
    @Override
    public void rent() {
        System.out.println("I want to rent my house.");
    }

    @Override
    public void hello(String str) {
        System.out.println("Hello, " + str);
    }
}
