package com.luvIsCode.springboot.thymeleafdemo.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    //add a controller method to show the form
    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    //add a controller method to process the form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    //need a controller method to read form data and add data to form
    //using httpServerlet
    @RequestMapping("/processFormVersionTwo")
   public String letsShoutdude(HttpServletRequest request, Model model){
        //read teh request parameter from the html form
        String theName = request.getParameter("studentName");
        //convert all the data to uppercase
        theName = theName.toUpperCase();
        //create the message
        String result = "yo!!" + theName;
        //finally add message to model
        model.addAttribute ("message",result);

        return "helloworld";
    }

    //now we will use bind variable using @RequestParam Annotation
    @GetMapping("/processFormVersionThree")
    public String processFormVersionThree(
            @RequestParam("studentName")String theName, Model model){

        //convert all the data to uppercase
        theName = theName.toUpperCase();
        //create the message
        String result = "hello my friend!!" + theName;
        //finally add message to model
        model.addAttribute ("message",result);

        return "helloworld";
    }

}
