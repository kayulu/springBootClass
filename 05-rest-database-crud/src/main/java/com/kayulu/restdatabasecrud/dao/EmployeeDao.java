package com.kayulu.restdatabasecrud.dao;

import com.kayulu.restdatabasecrud.entities.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAll();
    public Employee findById(int id);
    public void save(Employee employee);
    public void deleteById(int id);
    Employee update(Employee employee);
}
