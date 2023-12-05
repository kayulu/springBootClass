package com.kayulu.restdatabasecrud.rest;

import com.kayulu.restdatabasecrud.entities.Employee;
import com.kayulu.restdatabasecrud.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    // service layer
    private final EmployeeService employeeService;

    // constructor-injection
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }
}
