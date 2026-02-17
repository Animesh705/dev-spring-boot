package com.keepcoding.springboot.demo.mycoolapp.rest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class funRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "coach:" + coachName + ", team:" + teamName;
    }

    @GetMapping("/")
    public String sayHello() {
        return "Hello World!";
    }
    // expose a new endpoint for "workout"

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Daily workout!";
    }

    @GetMapping("/fortune")
    public String getDailyFortune() {
        return "today is your lucky day.";
    }


}