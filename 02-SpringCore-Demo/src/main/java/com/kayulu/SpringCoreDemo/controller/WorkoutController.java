package com.kayulu.SpringCoreDemo.controller;

import com.kayulu.SpringCoreDemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorkoutController {
    private final Coach aCoach;

    @Autowired  // you can use @Qualifier also for setter-injection
    public WorkoutController(@Qualifier("tennisCoach") Coach aCoach) {
        this.aCoach = aCoach;
    }

    @GetMapping("/getWorkout")
    public String getWorkout() {
        return aCoach.getDailyWorkout();
    }
}
