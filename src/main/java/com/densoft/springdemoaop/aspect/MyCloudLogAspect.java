package com.densoft.springdemoaop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyCloudLogAspect {
    @Before("com.densoft.springdemoaop.aspect.AOPExpressions.forDAOPackageNoGetterSetter()")
    public void logToCloudAsync() {
        System.out.println("\n ======>>> Logging to cloud in async fashion");
    }
}
