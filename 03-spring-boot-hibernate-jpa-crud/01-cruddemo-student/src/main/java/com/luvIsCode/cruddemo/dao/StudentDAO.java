package com.luvIsCode.cruddemo.dao;
import com.luvIsCode.cruddemo.entity.Student;
public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);


}
