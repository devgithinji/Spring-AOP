package com.densoft.springdemoaop.DAO;

import com.densoft.springdemoaop.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + " : Doing my db work: adding an account");
    }

    public boolean doWork() {
        System.out.println(getClass() + " : doWork()");
        return true;
    }
}
