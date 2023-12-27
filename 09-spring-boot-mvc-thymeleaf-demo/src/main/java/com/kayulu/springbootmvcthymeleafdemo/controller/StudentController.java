package com.kayulu.springbootmvcthymeleafdemo.controller;

import com.kayulu.springbootmvcthymeleafdemo.model.Student;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    @GetMapping("/studentForm")
    public String getStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);

        return "student-form";
    }

    @PostMapping("/studentSubmit")
    public String processStudent(@ModelAttribute("student") Student student, Model model) {

        model.addAttribute("student", student);

        System.out.println("First Name: " + student.getFirstName());
        System.out.println("Last Name: " + student.getLastName());

        return "studentInfo";
    }
}
