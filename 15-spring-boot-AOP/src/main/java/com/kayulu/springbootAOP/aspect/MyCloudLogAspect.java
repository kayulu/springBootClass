package com.kayulu.springbootAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyCloudLogAspect {
    @Autowired
    MyPointcutExpressions myPointcutExpressions;

    @Before("MyPointcutExpressions.inDaoWithoutSetGet()")
    public void loggingThings() {
        System.out.println("\n==========> executing MyCloudLogAspect.@Before advice");
    }
}
