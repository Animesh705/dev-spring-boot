package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    //adding field
    private EmployeeService employeeService;
    //adding constructor injection
    public EmployeeController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }
    //addd mapping for "/List"
    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        //get the employees from db
        List<Employee> employees = employeeService.findAll();
        //add to the spring model
        theModel.addAttribute("employees",employees);
        return "list-employees";
    }
}
