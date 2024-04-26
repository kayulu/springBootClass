package com.kayulu.springbootAOP.dao;

import com.kayulu.springbootAOP.Account;

public interface AccountDAO {
    void addAccount(Account account, boolean vipFlag);
    void synchronizeAccount();

    String getName();

    void setName(String name);

    String getServiceCode();

    void setServiceCode(String serviceCode);
}
