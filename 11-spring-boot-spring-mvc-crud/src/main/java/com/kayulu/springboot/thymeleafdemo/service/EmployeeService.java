package com.kayulu.springboot.thymeleafdemo.service;

import com.kayulu.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    List<Employee> findAllByOrderByLastNameAsc();

    Employee findById(int theId);

    Employee save(Employee theEmployee);

    void deleteById(int theId);

}
