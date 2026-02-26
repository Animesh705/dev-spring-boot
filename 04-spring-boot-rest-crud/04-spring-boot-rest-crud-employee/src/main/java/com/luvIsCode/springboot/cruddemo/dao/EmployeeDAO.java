package com.luvIsCode.springboot.cruddemo.dao;

import com.luvIsCode.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface EmployeeDAO {

    List<Employee> findAll();
}
