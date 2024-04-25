package com.kayulu.springbootAOP.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MembershipDaoImpl implements MembershipDAO {
    @Override
    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN MEMBERSHIP ACCOUNT");
    }

    @Override
    public boolean addSillyThings() {
        System.out.println(getClass() + ": ADDING SILLY STUFF");
        return false;
    }
}
