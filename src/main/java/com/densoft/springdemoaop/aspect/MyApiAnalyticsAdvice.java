package com.densoft.springdemoaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAdvice {
    @Before("com.densoft.springdemoaop.aspect.AOPExpressions.forDAOPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n=======>>> Performing API analytics <<<<========");
    }
}
