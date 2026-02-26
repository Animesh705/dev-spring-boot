package com.luvIsCode.springboot.cruddemo.rest;

import com.luvIsCode.springboot.cruddemo.dao.EmployeeDAO;
import com.luvIsCode.springboot.cruddemo.entity.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeDAO  employeeDAO;

    //quick and dirty: inject employee dao
    public EmployeeRestController(EmployeeDAO theEmployeeDAO){
        employeeDAO= theEmployeeDAO;
    }
    //expose"/employees" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> finalAll(){
        return  employeeDAO.findAll();
    }

}
