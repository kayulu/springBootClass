package com.kayulu.SpringCoreDemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Dive into dedicated batting cage sessions to sharpen your hitting prowess on the diamond!";
    }
}
