package com.luvIsCode.springcoredemo.rest;

import com.luvIsCode.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    // define a private field for dependencies
    private Coach myCoach;

    /*
// constructor injection
    @Autowired
    public DemoController(@Qualifier("trackCoach")Coach theCoach)
    {
        myCoach = theCoach;
    }
*/

    @Autowired
    public void setCoach( Coach theCoach){
        myCoach= theCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {

        return myCoach.getDailyWorkout();
    }
}
