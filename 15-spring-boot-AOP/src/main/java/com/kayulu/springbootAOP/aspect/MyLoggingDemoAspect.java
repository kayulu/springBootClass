package com.kayulu.springbootAOP.aspect;

import com.kayulu.springbootAOP.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLoggingDemoAspect {

    @Before("MyPointcutExpressions.inDaoWithoutSetGet()")
    public void loggingThings(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();

        System.out.println("\n==========> executing MyLoggingDemoAspect.@Before advice");
        System.out.println("Method: " + methodSignature.getMethod());

        for(Object arg : args) {
            if(arg instanceof Account theArg) {
                System.out.println("Account Name: " + theArg.getName());
                System.out.println("Account Level: " + theArg.getLevel());
            }
        }


    }
}
