
package com.example.webdemo.domain.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectJTest {

    @Pointcut("execution(* *.test(..))")
    public void test(){

    }

    @Before("test()")
    public void beforeTest(){
        System.out.println("前置通知消息。");
    }

    @After("test()")
    public void afterTest(){
        System.out.println("后置通知消息。");
    }

    @Around("test()")
    public Object aroundTest(ProceedingJoinPoint point){
        System.out.println("环绕通知前消息。");
        Object object = null;
        try {
            object = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("环绕通知后消息。");
        return object;
    }
}
