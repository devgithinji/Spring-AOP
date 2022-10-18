package com.densoft.springdemoaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyDemoLoggingAspect {

    //this is an aspect where we add all our related advices for logging



    @Before("execution(* com.densoft.springdemoaop.DAO.*.*(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n=======>>> Executing @Before advice on addAccount() <<<<========");
    }
}
