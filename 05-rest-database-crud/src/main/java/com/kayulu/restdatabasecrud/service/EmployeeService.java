package com.kayulu.restdatabasecrud.service;

import com.kayulu.restdatabasecrud.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
}
