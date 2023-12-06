package com.kayulu.restdatabasecrud.service;

import com.kayulu.restdatabasecrud.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee employee);
    public Employee update(Employee employee);
    public void deleteById(int id);
}
