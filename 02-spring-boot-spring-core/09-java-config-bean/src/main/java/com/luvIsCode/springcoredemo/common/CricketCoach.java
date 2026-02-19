package com.luvIsCode.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    public CricketCoach(){
        System.out.println("in constructor: "+ getClass().getSimpleName() );
    }
/*
    //define our init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("IN doMyStartupStuff(): "+getClass().getSimpleName());
    }
    //define our destroy mehtod
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("IN doMyCleanupStuff(): "+getClass().getSimpleName());
    }
 */
    @Override
    public String getDailyWorkout() {
        return "practice fast bowling for 15 mins :-}";
    }
}
