package com.luvIsCode.springboot.thymeleafdemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {

    //add a controller method to show the form
    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //add a controller method to process the form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

}
