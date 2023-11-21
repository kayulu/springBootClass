package com.kayulu.SpringCoreDemo.common;

// This component is created programmatically in a @Configuration class using the @Bean annotation
// hence there is no @Component annotation here
public class SwimCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Swim 10 lanes under 10 minutes";
    }
}
