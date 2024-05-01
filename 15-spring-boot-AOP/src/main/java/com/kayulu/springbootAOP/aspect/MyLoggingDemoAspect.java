package com.kayulu.springbootAOP.aspect;

import com.kayulu.springbootAOP.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Order(1)
public class MyLoggingDemoAspect {

    @Before("MyPointcutExpressions.inDaoWithoutSetGet()")
    public void loggingThings(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Object[] args = joinPoint.getArgs();

        System.out.println("\n==========> executing MyLoggingDemoAspect.@Before advice");
        System.out.println("{\nMethod: " + methodSignature.getMethod());

        for (Object arg : args) {
            if (arg instanceof Account theArg) {
                System.out.println("Account Name: " + theArg.getName());
                System.out.println("Account Level: " + theArg.getLevel());
            }
        }

        System.out.println("}\n");
    }

    @AfterReturning(
            pointcut = "MyPointcutExpressions.callingFindAccounts()",
            returning = "result")
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {

        for(Account account : result) {
            String name = account.getName();
            if(!name.contains("check OK!"))
                account.setName(account.getName() + " - check OK!");
        }
        System.out.println("\n==========> executing MyLoggingDemoAspect.@AfterReturning advice");
        System.out.println("{\nNumber of accounts: " + result.size());
        System.out.println("}\n");
    }

    @AfterThrowing(
            pointcut = "MyPointcutExpressions.callingFindAccounts())",
            throwing = "theException")
    public void afterThrowingInFindAccounts(JoinPoint joinPoint, Throwable theException) {
        System.out.println("\n==========> executing MyLoggingDemoAspect.@AfterThrowing advice");
        System.out.println("{");
        System.out.println("No accounts found: " + theException);
        System.out.println("}\n");
    }

    @After("MyPointcutExpressions.callingFindAccounts())")
    public void afterFindAccounts(JoinPoint joinPoint) {
        System.out.println("\n==========> executing MyLoggingDemoAspect.@After (finally) advice");
        System.out.println("{");
        System.out.println("@After advice is called always, regardless of outcome");
        System.out.println("}\n");
    }

    @Around("MyPointcutExpressions.callingGetFortune())")
    public String aroundGetFortune(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("\n==========> executing MyLoggingDemoAspect.@Around advice");
        System.out.println("{---");

        System.out.println("Before proceed()");
        long before = System.currentTimeMillis();

        String fortune = (String)proceedingJoinPoint.proceed();

        System.out.println("After proceed()");
        long after = System.currentTimeMillis();

        System.out.println("Duration in ms: " + (after - before));
        System.out.println("---}\n");

        return fortune;
    }
}
