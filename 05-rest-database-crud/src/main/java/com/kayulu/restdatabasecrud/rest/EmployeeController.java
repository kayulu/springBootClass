package com.kayulu.restdatabasecrud.rest;

import com.kayulu.restdatabasecrud.entities.Employee;
import com.kayulu.restdatabasecrud.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Note that most of these methods should return a EntityResponse object.
// That way headers could be set appropriately according to request status and so on

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    // service layer
    private final EmployeeService employeeService;

    // constructor-injection
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    List<Employee> getAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/{id}")
    Employee findById(@PathVariable int id) {
        return employeeService.findById(id);
    }

    @PostMapping
    void save(@RequestBody Employee employee) {
        employeeService.save(employee);
    }

    @PutMapping
    Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable int id) {
        employeeService.deleteById(id);
    }
}
