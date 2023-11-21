package com.kayulu.SpringCoreDemo.config;

import com.kayulu.SpringCoreDemo.common.Coach;
import com.kayulu.SpringCoreDemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    // The primary motivation of using @Bean is to make an existing third party class available to Spring framework
    // If 3rd party classes are used, we can't edit the classes source code and add @Component for example
    @Bean("aquatic") // set a bean-id that is different from default
    public Coach swimCoach() {  // remember: bean-id defaults to method name
        return new SwimCoach();
    }
}
