package com.densoft.springdemoaop;

import com.densoft.springdemoaop.DAO.AccountDAO;
import com.densoft.springdemoaop.DAO.MemberShipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingDemoApp {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        //get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        MemberShipDAO memberShipDAO = context.getBean("memberShipDAO", MemberShipDAO.class);

        //call the business method
        List<Account> accountList = null;

        try {
            boolean tripWire = true;
            accountList = accountDAO.findAccounts(tripWire);
        } catch (Exception e) {
            System.out.println("Main program ....caught exception " + e);
        }
        //display the accounts
        System.out.println("\n main Program: AfterThrowingDemo App");
        System.out.println("----------");
        System.out.println(accountList);
        System.out.println("\n");


        //close the context
        context.close();
    }
}
