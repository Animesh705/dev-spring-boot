package com.luvIsCode.cruddemo;

import com.luvIsCode.cruddemo.dao.StudentDAO;
import com.luvIsCode.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


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

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);
			//deleteAllStudent(studentDAO);
		};
	}

	//deleting all the student
	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("deleting all student");
		int numRowDeleted = studentDAO.deleteAll();
		System.out.println("no. pf rows deleted: "+ numRowDeleted);
	}

	//creating a method to delete student using id
	private void deleteStudent(StudentDAO studentDAO) {
		int StudentId = 3;
		System.out.println("deleteing the student with id: "+ StudentId);
		studentDAO.delete(StudentId);

	}

	//writing a method to update the obj.
	private void updateStudent(StudentDAO studentDAO){
		//retrieve student based on the id: primary key
		int studentId = 4;
		System.out.println("getting studentg with id: "+ studentId);
		Student myStudent =studentDAO.findById(studentId);
		System.out.println("updating student ......");

		//change first name to "scooby"
		myStudent.setFirstName("Arjun");
		//update the student
		studentDAO.update(myStudent);

		//display update student
		System.out.println("Update student: "+ myStudent);
	}

	//searching all the student with lastname as duck, (JPQL Name parameter)
	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("duck");
		//display list of student
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}


	}

	private void queryForStudents(StudentDAO studentDAO) {
		//get a list of all student
		List<Student> theStudents = studentDAO.findAll();
		//display the list of all student
		for(Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	//creating a method for reading
	private void readStudent(StudentDAO studentDAO){

		//create a student object
		System.out.println("creating a new student object...");
		Student tempStudent = new Student("Daffy","Duck","daffyduck@gmail.com");
		//save the student
		System.out.println("saving the student..");
		studentDAO.save(tempStudent);

		//display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("saved student. generate id: " + theId);

		//retrieve student based in the id: primary key
		System.out.println("retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		//display student
		System.out.println("found the student: " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO){
		//create multiple students
		System.out.println("creating new student object ...");
		Student tempStudent1 = new Student("paul","doe","paul@luv2code.como");
		Student tempStudent2 = new Student("mary","oe","mary@luv2code.como");
		Student tempStudent3 = new Student("bonita","loe","bonita@luv2code.como");

		//save the objects
		System.out.println("saving the student...");
		studentDAO.save(tempStudent1);
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
