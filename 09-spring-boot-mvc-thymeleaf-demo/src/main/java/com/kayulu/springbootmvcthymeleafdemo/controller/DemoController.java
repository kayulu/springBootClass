package com.kayulu.springbootmvcthymeleafdemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;


@Controller
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("theDate", LocalDate.now());

        // Note: Thymeleaf dependency was added to pom.xml.
        // Therefore, Spring Boot sets up the template resolvers for Thymeleaf.
        // by default resolvers are in src/main/resources/templates
        // looks for:
        // src/main/resources/templates/sayhello.html
        // will be interpreted as the view or template
        return "sayhello";
    }
}
