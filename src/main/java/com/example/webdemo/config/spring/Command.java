package com.example.webdemo.config.spring;

/**
 * Command
 *
 * @author Lindong Zhao
 * @create 2019-03-09 16:38
 **/
public interface Command {
    void setState(Object commandState);
    Object execute();
}
