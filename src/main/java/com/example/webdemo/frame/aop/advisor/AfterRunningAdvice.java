

package com.example.webdemo.frame.aop.advisor;

import java.lang.reflect.Method;

public interface AfterRunningAdvice extends Advice {
    Object after(Object returnVal, Method method, Object[] args, Object target);
}
