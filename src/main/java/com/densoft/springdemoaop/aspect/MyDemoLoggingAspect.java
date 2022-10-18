package com.densoft.springdemoaop.aspect;

import com.densoft.springdemoaop.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;


@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    Logger logger = Logger.getLogger(MyDemoLoggingAspect.class.getName());

    //this is an aspect where we add all our related advices for logging


    @Before("com.densoft.springdemoaop.aspect.AOPExpressions.forDAOPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint) {
        logger.info("\n=======>>> Executing @Before advice on addAccount() <<<<========");
        //display method signature
        Signature methodSignature = joinPoint.getSignature();
        logger.info(methodSignature.toShortString());
        //display method arguments
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if (arg instanceof Account) {
                Account account = (Account) arg;
                logger.info("account name " + account.getName());
                logger.info("account level " + account.getLevel());
            }
        }
    }

    @AfterReturning(value = "execution(* com.densoft.springdemoaop.DAO.AccountDAO.findAccounts(..))", returning = "result")
    public void afterReturningAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();
        logger.info("Executing @AfterReturning: " + method);
        logger.info("\n =====>>> result is: " + result);
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
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n ======> Executing @AfterThrowing on method " + method);

        //log the exception
        logger.info("\n ====> The exception is: " + exception);
    }

    @After("execution(* com.densoft.springdemoaop.DAO.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        //print the method signature
        String method = joinPoint.getSignature().toShortString();
        logger.info("\n ======> Executing @After (finally) on method " + method);
        logger.info("\n ====> Executing the @After advice ");
    }


    @Around("execution(* com.densoft.springdemoaop.service.*.getFortune(..))")
    public Object aroundGetFortuneAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("starting");
        long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long duration = end - begin;
        logger.info("\n ======> Duration: " + duration + " milliseconds");

        return result;
    }

}
