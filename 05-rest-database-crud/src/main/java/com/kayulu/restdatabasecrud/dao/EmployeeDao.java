package com.kayulu.restdatabasecrud.dao;

import com.kayulu.restdatabasecrud.entities.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAll();
}
