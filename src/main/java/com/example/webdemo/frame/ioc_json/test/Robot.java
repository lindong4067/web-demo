package com.example.webdemo.frame.ioc_json.test;

import lombok.Data;

@Data
public class Robot {
    private String name;
    private Hand hand;
    private Mouth mouth;

    public void show() {
        System.out.println("Robot Running ... " + name);
        hand.waveHand();
        mouth.speak();
    }
}
