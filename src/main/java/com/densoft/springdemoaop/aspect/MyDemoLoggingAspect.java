package com.densoft.springdemoaop.aspect;

import com.densoft.springdemoaop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    //this is an aspect where we add all our related advices for logging


    @Before("com.densoft.springdemoaop.aspect.AOPExpressions.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        System.out.println("\n=======>>> Executing @Before advice on addAccount() <<<<========");
        //display method signature
        Signature methodSignature = joinPoint.getSignature();
        System.out.println(methodSignature);
        //display method arguments
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Account) {
                Account account = (Account) arg;
                System.out.println("account name " + account.getName());
                System.out.println("account level " + account.getLevel());
            }
        }
    }

    @AfterReturning(value = "execution(* com.densoft.springdemoaop.DAO.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("Executing @AfterReturning: " + method);
        System.out.println("\n =====>>> result is: " + result);
        //modify the result
        //convert account names to uppercase
        if (!result.isEmpty()) {
            convertNamesToUpperCase(result);
        }

    }

    private void convertNamesToUpperCase(List<Account> result) {
        for (Account account : result) {
            account.setName(account.getName().toUpperCase());
        }
    }

    @AfterThrowing(value = "execution(* com.densoft.springdemoaop.DAO.AccountDAO.findAccounts(..))", throwing = "exception")
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {

        //print the method signature
        String method  = joinPoint.getSignature().toShortString();
        System.out.println("\n ======> Executing @AfterThrowing on method "+method);

        //log the exception
        System.out.println("\n ====> The exception is: " + exception);
    }

}
