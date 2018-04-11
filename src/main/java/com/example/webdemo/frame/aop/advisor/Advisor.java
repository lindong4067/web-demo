

package com.example.webdemo.frame.aop.advisor;

import lombok.Data;

@Data
public class Advisor {
    private Advice advice;
    private Pointcut pointcut;
}
