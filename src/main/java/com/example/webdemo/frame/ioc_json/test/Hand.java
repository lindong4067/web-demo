

package com.example.webdemo.frame.ioc_json.test;

import lombok.Data;

@Data
public class Hand {
    private String name;
    public void waveHand(){
        System.out.println("Wave Hand ... " + name);
    }
}
