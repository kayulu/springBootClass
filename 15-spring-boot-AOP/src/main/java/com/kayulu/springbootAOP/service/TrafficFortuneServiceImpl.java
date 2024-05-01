package com.kayulu.springbootAOP.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficFortuneServiceImpl implements TrafficFortune {
    @Override
    public String getFortune() {
        try {
            // simulate hard work
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return "Expect heavy traffic this morning!!!";
    }
}
