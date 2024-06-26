package com.kayulu.springbootAOP.aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class MyPointcutExpressions {
    @Pointcut("execution(* com.kayulu.springbootAOP.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* com.kayulu.springbootAOP.dao.*.set*(..))")
    public void setter() {}

    @Pointcut("execution(* com.kayulu.springbootAOP.dao.*.get*(..))")
    public void getter() {}

    @Pointcut("forDaoPackage() && !(setter() || getter())") // exclude setter() and getter() method calls
    public void inDaoWithoutSetGet() {}

    @Pointcut("execution(* com.kayulu.springbootAOP.dao.*.find*(..))")
    public void callingFindAccounts() {}

    @Pointcut("execution(* com.kayulu.springbootAOP.service.*.getFortune(..))")
    public void callingGetFortune() {}
}
