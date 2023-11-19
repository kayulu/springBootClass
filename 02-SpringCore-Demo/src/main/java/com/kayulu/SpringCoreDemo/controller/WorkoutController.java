package com.kayulu.SpringCoreDemo.controller;

import com.kayulu.SpringCoreDemo.coaches.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {
    private final Coach coach;

    @Autowired  // optional because there is only one constructor
    public WorkoutController(Coach coach) {
        this.coach = coach;
    }

    @GetMapping("/getWorkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
