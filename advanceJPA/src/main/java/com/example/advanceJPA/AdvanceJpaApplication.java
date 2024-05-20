package com.example.advanceJPA;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AdvanceJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdvanceJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO,
											   StudentDetailsDAO studentDetailsDAO,
											   CourseDAO courseDAO,
											   InstructorDAO instructorDAO) {
		return runner -> {

			// add records individually
//			Student student = new Student();
//			student.setFirstName("Soham");
//			studentDAO.createStudent(student);
//
//			StudentDetails studentDetails = new StudentDetails();
//			studentDetails.setAge(23);
//			studentDetails.setStudent(student);
//			studentDetailsDAO.createStudentDetails(studentDetails);

			// create student record via student details object
//			Student student = new Student("Patkar");
//			StudentDetails studentDetails = new StudentDetails(24);
//			studentDetails.setStudent(student);
//			studentDetailsDAO.createStudentDetails(studentDetails);

            // find student using studentDetails entity
//            StudentDetails studentDetails = studentDetailsDAO.findStudentDetailsById(1);
//            System.out.println(studentDetails.getStudent().getFirstName());

			// get studentdetails from student
//			Student student = studentDAO.findStudentById(1);
//			System.out.println(student.getStudentDetails().getAge());

			// create instructor via course
//			Instructor instructor = new Instructor("sam");
//			Course course = new Course("Java");
//			course.setInstructor(instructor);
//			courseDAO.createCourse(course);

			// create 1 more course with same instructor,
			// we can't directly set this object as it throws detached entity error
//			Instructor instructor = instructorDAO.findInstructorById(1);
//			Course course = new Course("Python");
//			courseDAO.createCourse(course, instructor.getInstructorId());

//			System.out.println(courseDAO.findCourseById(1).getInstructor().getFirstName());

//			System.out.println(instructorDAO.findCourseByInstructorId(1));

//			System.out.println(instructorDAO.findInstructorByIdJoinFetch(1).getCourses());

			// create course and student
//			Instructor instructor = new Instructor("Robert");
//			Student student = new Student("samuel");
//			Course course = new Course("Angular");
//			course.addStudent(student);
//			course.setInstructor(instructor);
//			courseDAO.createCourse(course);

			// get All students from courseId
			Course course = courseDAO.findCourseAndStudentById(5);
			for (Student student : course.getStudents()) {
				System.out.println(student.getFirstName());
			}
		};
	}

}
