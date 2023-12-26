package com.kayulu.springbootmvcthymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class HelloWorldController {
    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    @GetMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @GetMapping("/processFormVersionTwo")
    public String shoutUp(HttpServletRequest request, Model model) {
        String studentName = request.getParameter("studentName");
        studentName = studentName.toUpperCase();

        String message = "Yo! " + studentName;

        model.addAttribute("message", message);

        return "helloworld";
    }

}
