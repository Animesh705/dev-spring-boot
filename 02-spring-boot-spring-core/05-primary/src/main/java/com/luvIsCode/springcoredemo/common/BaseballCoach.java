package com.luvIsCode.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "practice batting for 30 mins :-}";
    }
}
