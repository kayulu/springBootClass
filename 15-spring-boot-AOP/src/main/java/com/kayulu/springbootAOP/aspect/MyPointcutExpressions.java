package com.kayulu.springbootAOP.aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class MyPointcutExpressions {
    @Pointcut("execution(* com.kayulu.springbootAOP.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* *.set*(..))")
    public void setter() {}

    @Pointcut("execution(* *.get*(..))")
    public void getter() {}

    @Pointcut("forDaoPackage() && !(setter() || getter())") // exclude setter() and getter() method calls
    public void inDaoWithoutSetGet() {}
}
