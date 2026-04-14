package com.luvIsCode.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class demoController {

    //create a mapping for "/hello"
    @GetMapping("/hello")
    public String sayHello(Model theModel){
        theModel.addAttribute("theData",java.time.LocalDateTime.now());
        //we have thymeleaf dependency in maven pom, spring boot will auto-configure to use thymeleaf
        return "helloworld";
    }
}
