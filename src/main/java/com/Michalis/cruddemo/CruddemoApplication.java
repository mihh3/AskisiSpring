package com.Michalis.cruddemo;

import com.Michalis.cruddemo.dao.DeegreesRepository;
import com.Michalis.cruddemo.dao.StudentDAO;
import com.Michalis.cruddemo.entity.Degree;
import com.Michalis.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}



	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO, DeegreesRepository degreeDAO){

		return runner -> {
			//readStudent(studentDAO) ;


			//updateStudent(studentDAO);

			//deleteAllStudents(studentDAO);

			createDegrees(degreeDAO);
			createMultipleStudents(studentDAO);

			// Printing All Degrees
			printAllDegrees(degreeDAO);

			// Printing All Students
			queryForStudents(studentDAO);


			// Search a degree by its title
			if(!degreeDAO.findByTitle("Applied Informatics").isEmpty())
			{
				System.out.println("Degree Found! : " + degreeDAO.findByTitle("Applied Informatics"));
			}
			else
				System.out.println("Degree Not Found !");


			// Retrieve Students by accepted attribute
			System.out.println(studentDAO.findByAccepted(true));

			// Retrieve Students by highest degree id = 1 (Applied Informatics)
			System.out.println(studentDAO.findByDegreeId(1));

			// Delete a Degree with no matching Student
			degreeDAO.deleteDegree(3);


			// Deleting a Student with id = 3
			//deleteStudent(studentDAO);


			// Searching a Student by his last name .
			//queryForStudentsByLastName(studentDAO);


		} ;


	}

	private void printAllDegrees(DeegreesRepository degreeDAO) {
		System.out.println(degreeDAO.returnAllRecords());
	}


	private void createDegrees(DeegreesRepository degreeDAO) {
		System.out.println("Creating 3 new Degree objects  ...");
		Degree d1 = new Degree("Applied Informatics");
		Degree d2 = new Degree("Dance");
		Degree d3 = new Degree("Physics");

		// Adding on purpose a degree with the same title so the addDegree method prints that this one already exists .

		Degree d4 = new Degree("Applied Informatics");

		degreeDAO.addDegree(d1);
		degreeDAO.addDegree(d2);
		degreeDAO.addDegree(d3);
		degreeDAO.addDegree(d4);
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting All Students ! ");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count : " +numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		int studentId = 3;
		System.out.println("Deleting student id : " +studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		// retrieve student based on the id : primary key
		int studentId = 1 ;
		System.out.println("Getting student with id : "  +studentId);
		Student myStudent = studentDAO.findById(studentId);
		// change first name to ''John''
		System.out.println("Updating Student "  +studentId);
		myStudent.setFirstName("John");
		// update the student
		studentDAO.update(myStudent);
		// display the updated student
		System.out.println("Updated Student : " +myStudent);

	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Anastasiadis") ;

		//	display a list of students
		for(Student tempStudent: theStudents){
			System.out.println(tempStudent) ;
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();


		// display list of students
		for(Student tempStudent: theStudents) {
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		// create a student object
		System.out.println("Creating new student object ");
		Student tempStudent = new Student("Michalis","Anastasiadis","michael2_a@yahoo.com", Date.valueOf("2024-09-10"),"All Good",1,true);

		// save the student
		System.out.println("Saving the Student");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved Student id : " + theId);

		// retrieve student based on the id : primary key
		System.out.println("Retrieving student with id : " + theId);
		Student myStudent = studentDAO.findById(theId) ;

		// display student
		System.out.println("Found the Student : " +myStudent);


	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Creating 3 new Student objects  ...");
		Student tempStudent1 = new Student("Michalis","Anastasiadis","michael2_a@dmail.com", Date.valueOf("2024-09-10"),"All Good",1,true);
		Student tempStudent2 = new Student("Las","Vegas","las@yahoo.com", Date.valueOf("2004-08-10"),"All Not Much Good",1,true);
		Student tempStudent3 = new Student("Hector","Cooper","hector@hotmail.com", Date.valueOf("2024-09-11"),"All Good",2,false);

		//save the students
		System.out.println("Saving the Students ! ");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);


	}

}
