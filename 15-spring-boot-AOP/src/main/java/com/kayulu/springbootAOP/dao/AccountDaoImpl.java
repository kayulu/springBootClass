package com.kayulu.springbootAOP.dao;

import com.kayulu.springbootAOP.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDaoImpl implements AccountDAO {
    private String name;
    private String serviceCode;

    @Override
    public void addAccount(Account account, boolean vipFlag) {
        System.out.println("\nAccountDaoImpl: DOING MY DB WORK: ADDING AN ACCOUNT");
    }

    @Override
    public void synchronizeAccount() {
        System.out.println("\nAccountDaoImpl: WORKING HARD...");
    }

    @Override
    public String getName() {
        System.out.println("\nAccountDaoImpl: getName()");
        return name;
    }

    @Override
    public void setName(String name) {
        System.out.println("\nAccountDaoImpl: setName()");
        this.name = name;
    }

    @Override
    public String getServiceCode() {
        System.out.println("\nAccountDaoImpl: getServiceCode()");
        return serviceCode;
    }

    @Override
    public void setServiceCode(String serviceCode) {
        System.out.println("\nAccountDaoImpl: setServiceCode()");
        this.serviceCode = serviceCode;
    }
}
