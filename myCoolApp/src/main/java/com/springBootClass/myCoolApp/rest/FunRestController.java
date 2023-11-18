package com.springBootClass.myCoolApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @Value("${developer.name}") //defined in application.resources
    private String devName;

    @GetMapping("/")
    public String sayHell() {
        return "Hello " + devName + "!";
    }
}
