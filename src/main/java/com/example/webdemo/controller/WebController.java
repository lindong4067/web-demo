

package com.example.webdemo.controller;

//import com.example.webdemo.domain.User;
//import com.example.webdemo.esa.snmp.SnmpUtil;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;

@Slf4j
@RestController
public class WebController {

    final FilterRegistrationBean registration;

    @Autowired
    public WebController(FilterRegistrationBean registration) {
        this.registration = registration;
    }

    @PostMapping("/hello")
    public Object test(HttpServletRequest request, HttpServletResponse response) {
//        Assert.assertNotNull("Age not null", user.getAddress());
//        Assert.assertNotNull("Name not null", user.getName());

//        Address address = user.getAddress();
//        System.out.println("------");
//        String name = user.getName();
//        int age = user.getAge();
//        System.out.println(address);
//        System.out.println(name);
//        System.out.println(age);
//        System.out.println("------");
//        System.out.println(user.toString());
        return "OK !";
    }

    @GetMapping("/hello")
    public Object test2() {
//        Assert.assertNotNull("Age not null", user.getAddress());
//        Assert.assertNotNull("Name not null", user.getName());

//        Address address = user.getAddress();
//        System.out.println("------");
//        String name = user.getName();
//        int age = user.getAge();
//        System.out.println(address);
//        System.out.println(name);
//        System.out.println(age);
//        System.out.println("------");
//        System.out.println(user.toString());
        InetAddress localHost = null;
        try {
            localHost = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "Hello World ! " + localHost;
    }

    @GetMapping("/watch/key")
    public Object watch() {
        log.info("Consul Watch OK! [GET]");
//        Map initParameters = registration.getInitParameters();
        return "Consul Watch OK! [GET][RESULT]";
//        return initParameters;
    }

    @PostMapping("/watch")
    public Object watchP() {
        log.info("Consul Watch OK! [POST]");
        return "Consul Watch OK! [POST][RESULT]";
    }
}
