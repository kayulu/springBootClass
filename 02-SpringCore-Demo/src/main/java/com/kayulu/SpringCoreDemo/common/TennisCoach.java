package com.kayulu.SpringCoreDemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) // remember that 'singleton' is default
public class TennisCoach implements Coach{

    public TennisCoach() {
        System.out.println("Constructor was called. ");
    }

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct method was called!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("@PreDestroy method was called!");
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }
}
