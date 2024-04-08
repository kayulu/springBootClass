package com.kayulu.springboot.demosecurity.service;

import com.kayulu.springboot.demosecurity.entity.User;
import com.kayulu.springboot.demosecurity.user.WebUser;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

	public User findByUserName(String userName);

	void save(WebUser webUser);

}
