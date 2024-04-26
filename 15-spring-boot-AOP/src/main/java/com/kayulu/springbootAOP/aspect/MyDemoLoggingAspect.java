package com.kayulu.springbootAOP.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.kayulu.springbootAOP.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* *.set*(..))")
    public void setter() {}
    @Pointcut("execution(* *.get*(..))")
    public void getter() {}

    @Pointcut("forDaoPackage() && !(setter() || getter())") // exclude setter() and getter() method calls
    public void inDaoWithoutSetGet() {}

    @Before("inDaoWithoutSetGet()")
    public void loggingThings() {
        System.out.println("\n==========> executing @Before advice");
    }
}
