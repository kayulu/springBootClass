package com.kayulu.springboot.demosecurity.dao;

import com.kayulu.springboot.demosecurity.entity.User;

public interface UserDao {

    User findByUserName(String userName);
    
}
