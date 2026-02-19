package com.luvIsCode.springcoredemo.common;

public class SwimCoach implements Coach{

    //swimCoach didnt has a component annotation , their for we configured it as a spring bean using @bean
    public SwimCoach(){
        System.out.println("In constructor: "+getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "practice swimming for 15 mins :-}";
    }
}
