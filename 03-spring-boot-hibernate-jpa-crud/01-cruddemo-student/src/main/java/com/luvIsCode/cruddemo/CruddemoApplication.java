package com.luvIsCode.cruddemo;

import com.luvIsCode.cruddemo.dao.StudentDAO;
import com.luvIsCode.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner ->{
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
	}

	private void createMultipleStudents(StudentDAO studentDAO){
		//create multiple students
		System.out.println("creating new student object ...");
		Student tempStudent1 = new Student("paul","doe","paul@luv2code.como");
		Student tempStudent2 = new Student("mary","oe","mary@luv2code.como");
		Student tempStudent3 = new Student("bonita","loe","bonita@luv2code.como");

		//save the objects
		System.out.println("saving the student...");
		studentDAO.save(tempStudent1	₹);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}
	private void createStudent(StudentDAO studentDAO){

		//create student object
		System.out.println("creating new student object ...");
		Student tempStudent = new Student("paul","doe","paul@luv2code.como");

		//save the student object
		System.out.println("saving the student...");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("saved Student. Generated id:" + tempStudent.getId());

	}

}
