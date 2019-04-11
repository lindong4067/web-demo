package com.example.webdemo.frame.ioc_json.test;

import lombok.Data;

@Data
public class Mouth {
    private String name;

    public void speak() {
        System.out.println("Say Hello Word ! " + name);
    }
}
