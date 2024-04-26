package com.kayulu.springbootAOP.dao;

import com.kayulu.springbootAOP.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDAO {
    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }
}
