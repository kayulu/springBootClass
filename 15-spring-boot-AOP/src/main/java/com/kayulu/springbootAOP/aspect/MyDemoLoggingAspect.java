package com.kayulu.springbootAOP.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // matches on any method call that starts with add*
    // and takes a parameter of type 'com.kayulu.springbootAOP.Account' and any return-type
    @Before("execution(* add*(..))")  // note that modifiers are optional
    public void beforeAddAccountAdvice() {
        System.out.println("\n==========> executing @Before advice on method");
    }
}
