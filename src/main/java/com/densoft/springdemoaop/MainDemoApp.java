package com.densoft.springdemoaop;

import com.densoft.springdemoaop.DAO.AccountDAO;
import com.densoft.springdemoaop.DAO.MemberShipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemoApp {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        //get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        MemberShipDAO memberShipDAO = context.getBean("memberShipDAO", MemberShipDAO.class);

        //call the business method
        List<Account> accountList = accountDAO.findAccounts();
        //display the accounts
        System.out.println("\n main Program: AfterReturningDemo App");
        System.out.println("----------");
        System.out.println(accountList);
        System.out.println("\n");
//        accountDAO.addAccount(new Account("dennis","4567"), true);
//        accountDAO.doWork();
//        accountDAO.getName();
//        accountDAO.setName("nurse");
//        accountDAO.getServiceCode();
//        accountDAO.setServiceCode("567");

//        memberShipDAO.addAccount();

        //close the context
        context.close();
    }
}
