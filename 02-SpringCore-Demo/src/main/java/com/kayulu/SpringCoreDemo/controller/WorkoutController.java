package com.kayulu.SpringCoreDemo.controller;

import com.kayulu.SpringCoreDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {
    private Coach coach;

    @Autowired
    public void setCoach(Coach coach) { // the name of the method doesn't matter
        this.coach = coach;
    }

    @GetMapping("/getWorkout")
    public String getDailyWorkout() {
        return coach.getDailyWorkout();
    }
}
