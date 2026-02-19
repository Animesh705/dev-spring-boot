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
    private Coach anotherCoach;

    /*
// constructor injection
    @Autowired
    public DemoController(@Qualifier("trackCoach")Coach theCoach)
    {
        myCoach = theCoach;
    }
*/

    @Autowired
    public void setCoach(
            @Qualifier("cricketCoach") Coach theCoach,
            @Qualifier("cricketCoach") Coach theAnotherCoach){
        System.out.println("in constructor: "+ getClass().getSimpleName() );
        myCoach= theCoach;
        anotherCoach = theAnotherCoach;
    }

    @GetMapping("/dailyWorkout")
    public String getDailyWorkout() {

        return myCoach.getDailyWorkout();
    }

    @GetMapping("/check")
    public String check(){
        //for singleton it will return true , and for prototype it will return false
        return "comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCoach);
    }
}
