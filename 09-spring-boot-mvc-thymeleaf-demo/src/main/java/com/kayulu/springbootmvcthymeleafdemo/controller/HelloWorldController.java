package com.kayulu.springbootmvcthymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

        String message = "Hey my friend from v3 " + studentName;

        model.addAttribute("message", message);

        return "helloworld";
    }

    @PostMapping("/processFormVersionThree")
    public String shoutUp(@RequestParam("studentName") String theName, Model model) {
        theName = theName.toUpperCase();

        String message = "Yo! " + theName;

        model.addAttribute("message", message);

        return "helloworld";
    }

}
