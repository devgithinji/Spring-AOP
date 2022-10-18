package com.densoft.springdemoaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {

    @Pointcut("execution(* com.densoft.springdemoaop.DAO.*.*(..))")
    public void forDaoPackage() {
    }

    //create a pointcut for getter methods
    @Pointcut("execution(* com.densoft.springdemoaop.DAO.*.get*(..))")
    public void getter() {
    }

    //create a pointcut for getter methods
    @Pointcut("execution(* com.densoft.springdemoaop.DAO.*.set*(..))")
    public void setter() {
    }

    //combine pointcut: include package ... exclude getter && setter
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDAOPackageNoGetterSetter(){}
}
