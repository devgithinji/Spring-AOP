package com.densoft.springdemoaop;

import com.densoft.springdemoaop.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;


public class AroundAdviceDemoWithLoggerApp {

    private static Logger logger = Logger.getLogger(AroundAdviceDemoWithLoggerApp.class.getName());

    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        //get the bean from spring container
        TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        logger.info("main program");

        logger.info("\n calling getFortune");

        //call the method
        String result = trafficFortuneService.getFortune();

        logger.info("fortune in the main app: " + result);

        //display the accounts
        logger.info("\n main Program: AroundDemo App");
        //close the context
        context.close();
    }
}
