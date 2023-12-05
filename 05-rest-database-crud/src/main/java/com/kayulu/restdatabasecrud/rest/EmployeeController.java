package com.kayulu.restdatabasecrud.rest;

import com.kayulu.restdatabasecrud.dao.EmployeeDao;
import com.kayulu.restdatabasecrud.entities.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    // this is a quick and dirty solution. Normally a service layer should be in between the controller and the
    // data access layer (dao).
    private final EmployeeDao employeeDao;

    // constructor-injection
    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GetMapping("/employees")
    List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }
}
