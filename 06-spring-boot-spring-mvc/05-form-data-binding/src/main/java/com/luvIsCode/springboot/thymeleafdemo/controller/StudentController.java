package com.luvIsCode.springboot.thymeleafdemo.controller;

import com.luvIsCode.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    //add countries from application.properties file , instead of hard coding them
    @Value("${countries}")
    private List<String> countries;

    //added list of fav prog lang in application.prop instead of hard coding them , favlanguage should match from application.prop
    @Value("${languages}")
    private List<String> languages;

    //first create a method for actually showing the form
    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){
        //create a student object
        Student theStudent = new Student();
        //add student object to the model
        theModel.addAttribute("student",theStudent);
      //adding countries name to the model
        theModel.addAttribute("countries",countries);
        //adding the list of fav prog lang to the model
        theModel.addAttribute("languages",languages);

        return "student-form";
    }
    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){

        //log the input data
        System.out.println("theStudent: " +theStudent.getFirstName()+" "+theStudent.getLastName());

        return "student-confirmation";
    }








}
