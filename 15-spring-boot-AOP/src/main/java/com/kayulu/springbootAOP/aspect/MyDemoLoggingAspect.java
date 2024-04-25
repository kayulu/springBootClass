package com.kayulu.springbootAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
    // matches on any method call named addAccount()
//    @Before("execution(public void addAccount())")

    // matches only on fully qualified method
//    @Before("execution(public void com.kayulu.springbootAOP.dao.AccountDAO.addAccount())")

    // matches on any method call that starts with add*
//    @Before("execution(public void add*())")

    // matches on any method call that starts with add* and any return-type
    @Before("execution(* add*())")  // note that modifiers are optional
    public void beforeAddAccountAdvice() {
        System.out.println("\n==========> executing @Before advice on method");
    }
}
