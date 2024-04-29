package com.kayulu.springbootAOP.aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLoggingDemoAspect {

    @Before("MyPointcutExpressions.inDaoWithoutSetGet()")
    public void loggingThings() {
        System.out.println("\n==========> executing @Before advice");
    }
}
