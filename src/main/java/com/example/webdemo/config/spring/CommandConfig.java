package com.example.webdemo.config.spring;


import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

/**
 * config
 *
 * @author Lindong Zhao
 * @create 2019-03-09 16:32
 **/
@Configurable
public class CommandConfig {

    @Bean
    @Scope("prototype")
    public AsyncCommand asyncCommand(){
        AsyncCommand command = new AsyncCommand();
        return command;
    }

    @Bean
    public CommandManager commandManager() {
        return new CommandManager() {
            @Override
            protected Command createCommand() {
                return asyncCommand();
            }
        };
    }
}
