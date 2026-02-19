package com.luvIsCode.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "practice your back hand valley for 15 mins :-}";
    }

}

