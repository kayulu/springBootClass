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

    // expose a new endpoint to check that dev-tools are working
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k!";
    }

    // another endpoint - just to see that devtools are working!!!
    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "Today is your lucky day.";
    }
}
