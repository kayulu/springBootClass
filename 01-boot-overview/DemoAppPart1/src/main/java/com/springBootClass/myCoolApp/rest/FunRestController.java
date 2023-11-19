package com.springBootClass.myCoolApp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
    // inject properties from 'application.properties'
    @Value("${coach.name}")
    String coachName;

    @Value("${team.name}")
    String teamName;

    @GetMapping("/teamInfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + ", Team: " + teamName;
    }
}
