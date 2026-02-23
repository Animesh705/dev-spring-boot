package com.luvIsCode.cruddemo.dao;
import ch.qos.logback.core.model.INamedModel;
import com.luvIsCode.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student theStudent);


    //adding a new method for reading
    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    //adding a new method to update
    void update(Student theStudent);

    void delete(Integer id);

    //for deleteing all the student
    int deleteAll();


}
