package com.luvIsCode.springcoredemo.rest;

import com.luvIsCode.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for dependencies
    private Coach myCoach;

    @Autowired
    public DemoController(Coach theCoach)
    {
        myCoach = theCoach;
    }
    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {

        return myCoach.getDailyWorkout();
    }
}
