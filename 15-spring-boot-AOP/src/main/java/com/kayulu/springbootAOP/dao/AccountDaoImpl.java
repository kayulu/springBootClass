package com.kayulu.springbootAOP.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDAO {
    @Override
    public void addAccount() {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}
