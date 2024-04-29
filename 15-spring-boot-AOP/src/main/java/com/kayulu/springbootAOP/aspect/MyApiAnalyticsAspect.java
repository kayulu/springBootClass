package com.kayulu.springbootAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiAnalyticsAspect {
    @Autowired
    MyPointcutExpressions myPointcutExpressions;

    @Before("MyPointcutExpressions.inDaoWithoutSetGet()")
    public void loggingThings() {
        System.out.println("\n==========> executing MyApiAnalyticsAspect.@Before advice");
    }
}
