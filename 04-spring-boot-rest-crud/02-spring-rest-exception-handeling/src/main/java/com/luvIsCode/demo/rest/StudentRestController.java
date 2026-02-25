package com.luvIsCode.demo.rest;

import com.luvIsCode.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    // define @postconstruct to load the student data .... only once
    @PostConstruct //->Run this method automatically right after the object is created and ready.
    public void loadData() {

        theStudents = new ArrayList<>();

        theStudents.add(new Student("Poornima", "Patel"));
        theStudents.add(new Student("Mario", "Rossi"));
        theStudents.add(new Student("Jack", "Jones"));
    }
    //define endpoint for "/students" -return list of student

    @GetMapping("/students")
    public List<Student> getStudents() {

        return theStudents;
    }

    //define endpoints or "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        //check the studentId again list size , if not in range throw exception
        if ((studentId >= theStudents.size()) || (studentId < 0)) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        }
        //just index into the list ....
        return theStudents.get(studentId);
    }

    //Add an exception handler using @ExceptionHandler
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        //you can chnage the below line,to change the error message to anything you want
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return Responsibility
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    //add another exception handler......to catch any exception(catch all)

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
        //create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        //you can chnage the below line,to change the error message to anything you want
        //error.setMessage("Bad Request, You DumbAss!!!!");
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return Responsibility
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
