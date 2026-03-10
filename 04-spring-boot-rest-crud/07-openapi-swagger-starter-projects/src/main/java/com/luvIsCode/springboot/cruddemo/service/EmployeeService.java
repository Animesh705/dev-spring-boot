package com.luvIsCode.springboot.cruddemo.service;

import com.luvIsCode.springboot.cruddemo.entity.Employee;

import java.util.*;

public interface EmployeeService {

    public List<Employee> findAll();

    //adding other methods for full crud support
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
