package com.kayulu.SpringCoreDemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class BaseballCoach implements Coach{
    public BaseballCoach() {
        System.out.println(this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Dive into dedicated batting cage sessions to sharpen your hitting prowess on the diamond!";
    }
}
