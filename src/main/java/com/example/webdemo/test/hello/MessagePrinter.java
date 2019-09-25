package com.example.webdemo.test.hello;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MessagePrinter {

    final private MessageService service;

    public MessagePrinter(@Qualifier("mockMessageService") MessageService service) {
        this.service = service;
    }

    public void printMessage() {
        System.out.println(this.service.getMessage());
    }
}
