package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {

    // This tells SpringSecurity to use JDBC authentication using the datasource specified in the properties file
    // It will also know how to access the related authentication tables (users, authorities) in the database because we
    // have followed a standard schema for them.
    @Bean
    JdbcUserDetailsManager jdbcUserDetailsManager(DataSource dataSource) {
        var manager = new JdbcUserDetailsManager(dataSource);

        // if you have your own db schema of storing users and passwords that differ from the default schema used by
        // spring security

        // remember: the ? will be replaced by the strings that the user puts in when logging in
        manager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id=?");
        manager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id=?");

        return manager;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(config ->
                config
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/{employeeId}").hasRole("ADMIN"));

        // use http basic authentication
        http.httpBasic(Customizer.withDefaults());

        http.csrf(AbstractHttpConfigurer::disable); // because this is not form based

        return http.build();
    }

}
