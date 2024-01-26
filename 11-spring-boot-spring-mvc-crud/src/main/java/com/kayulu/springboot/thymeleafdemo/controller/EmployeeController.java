package com.kayulu.springboot.thymeleafdemo.controller;

import com.kayulu.springboot.thymeleafdemo.entity.Employee;
import com.kayulu.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.findAll();

        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("showFormAdd")
    public String showFormAdd(Model model) {
        Employee employee = new Employee();

        model.addAttribute("employee", employee);

        return "employees/showFormAdd";
    }

    @PostMapping("save")
    public String save(@ModelAttribute Employee employee, Model model) {
        employeeService.save(employee);

        return "redirect:/employees/list"; // "Post/Redirect/Get" pattern (prevents resubmission of form data)
    }
}
