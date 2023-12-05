package com.kayulu.restdatabasecrud.service;

import com.kayulu.restdatabasecrud.dao.EmployeeDao;
import com.kayulu.restdatabasecrud.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
