package com.densoft.springdemoaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyDemoLoggingAspect {

    //this is an aspect where we add all our related advices for logging


    @Pointcut("execution(* com.densoft.springdemoaop.DAO.*.*(..))")
    public void forDaoPackage() {
    }

    //create a pointcut for getter methods
    @Pointcut("execution(* com.densoft.springdemoaop.DAO.*.get*(..))")
    private void getter() {
    }

    //create a pointcut for getter methods
    @Pointcut("execution(* com.densoft.springdemoaop.DAO.*.set*(..))")
    private void setter() {
    }

    //combine pointcut: include package ... exclude getter && setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    private void forDAOPackageNoGetterSetter(){}

    @Before("forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n=======>>> Executing @Before advice on addAccount() <<<<========");
    }

    @Before("forDaoPackage()")
    public void performApiAnalytics() {
        System.out.println("\n=======>>> Performing API analytics <<<<========");
    }
}
