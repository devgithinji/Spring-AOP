package com.densoft.springdemoaop.DAO;

import org.springframework.stereotype.Repository;

@Repository
public class MemberShipDAO {

    public boolean addAccount() {
        System.out.println(getClass() + " : Doing stuff: ADDING A MEMBERSHIP ACCOUNT");
        return true;
    }
}
