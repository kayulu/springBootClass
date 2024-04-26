package com.kayulu.springbootAOP.dao;

import com.kayulu.springbootAOP.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDAO {
    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public void synchronizeAccount() {
        System.out.println(getClass() + ": WORKING HARD...");
    }

    @Override
    public String getName() {
        System.out.println(getClass() + ": getName()");
        return name;
    }

    @Override
    public void setName(String name) {
        System.out.println(getClass() + ": setName()");
        this.name = name;
    }

    @Override
    public String getServiceCode() {
        System.out.println(getClass() + ": getServiceCode()");
        return serviceCode;
    }

    @Override
    public void setServiceCode(String serviceCode) {
        System.out.println(getClass() + ": setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
