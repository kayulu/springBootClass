package com.kayulu.restdatabasecrud.service;

import com.kayulu.restdatabasecrud.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee> findAll();
    public Optional<Employee> findById(int id);
    public void save(Employee employee);
    public Employee update(Employee employee);
    public void deleteById(int id);
}
