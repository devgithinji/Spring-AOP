package com.densoft.springdemoaop;

import com.densoft.springdemoaop.DAO.AccountDAO;
import com.densoft.springdemoaop.DAO.MemberShipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {
    public static void main(String[] args) {
        //read spring config java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
        //get the bean from spring container
        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

        MemberShipDAO memberShipDAO = context.getBean("memberShipDAO", MemberShipDAO.class);

        //call the business method
        accountDAO.addAccount(new Account(), true);
        accountDAO.doWork();

        memberShipDAO.addAccount();

        //close the context
        context.close();
    }
}
