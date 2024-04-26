package com.kayulu.springbootAOP.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    @Pointcut("execution(* com.kayulu.springbootAOP.dao.*.*(..))")
    public void forDaoPackage() {}

    // uses pointcut declaration named forDaoPackage()
    @Before("forDaoPackage()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n==========> executing @Before advice on method");
    }

    // uses pointcut declaration named forDaoPackage() for another advice
    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n==========> performing API analytics");
    }

    // yet another advice
    @After("forDaoPackage()")
    public void cleaningUp() {
        System.out.println("\n==========> cleanup work");
    }
}
