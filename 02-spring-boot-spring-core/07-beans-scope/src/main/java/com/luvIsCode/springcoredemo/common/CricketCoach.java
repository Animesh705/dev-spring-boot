package com.luvIsCode.springcoredemo.common;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("in constructor: "+ getClass().getSimpleName() );
    }
    @Override
    public String getDailyWorkout() {
        return "practice fast bowling for 15 mins :-}";
    }
}
