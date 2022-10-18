package com.densoft.springdemoaop;

import com.densoft.springdemoaop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AroundAdviceDemoApp {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        //get the bean from spring container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        //call the method
        String result = trafficFortuneService.getFortune(false);

        System.out.println("fortune in the main app: " + result);

        //display the accounts
        System.out.println("\n main Program: AroundDemo App");
        //close the context
        context.close();
    }
}
