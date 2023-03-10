package com.densoft.springdemoaop.DAO;

import com.densoft.springdemoaop.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountDAO {

    private String name;
    private String serviceCode;

    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " : Doing my db work: adding an account");
    }

    public boolean doWork() {
        System.out.println(getClass() + " : doWork()");
        return true;
    }

    public List<Account> findAccounts(boolean tripWire) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("dennis", "vvip"));
        accounts.add(new Account("paul", "vip"));
        accounts.add(new Account("patrick", "member"));

        if (tripWire) {
            throw new RuntimeException("Something went wrong");
        }
        return accounts;
    }

    public String getName() {
        System.out.println(getClass() + " : in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass() + " : in setName()");
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println(getClass() + " : in getServiceCode()");
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + " : in setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
