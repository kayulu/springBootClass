package com.kayulu.springboot.demosecurity.dao;

import com.kayulu.springboot.demosecurity.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
