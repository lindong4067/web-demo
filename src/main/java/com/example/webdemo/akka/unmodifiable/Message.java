

package com.example.webdemo.akka.unmodifiable;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public final class Message {

    private final int age;
    private final List<String> list;

    public Message(int age, List<String> list) {
        this.age = age;
        this.list = Collections.unmodifiableList(list);
    }


}
