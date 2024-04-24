package com.kayulu.springbootAdvancedMappings;

import com.kayulu.springbootAdvancedMappings.dao.AppDAO;
import com.kayulu.springbootAdvancedMappings.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

	private CommandLineRunner commandLineRunner;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

//		return runner -> {addSomeCourses(appDAO);};

//		return runner -> {createCourseWithStudents(appDAO);};

//		return runner -> {findCourseAndStudentsByCourseId(appDAO);};
//		return runner -> {findStudentAndCoursesByStudentId(appDAO);};

//		return runner -> {addCoursesToStudent(appDAO);};

		return runner -> {deleteStudentById(appDAO);};
	}


	private void deleteInstructorById(AppDAO appDAO) {
		appDAO.deleteInstructorById(1);
	}

	private void saveInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("Kay", "Ulu", "kay.ulu@example.de");
		InstructorDetail instructorDetail = new InstructorDetail("javaChannel", "Guitar");

		instructor.setInstructorDetail(instructorDetail);

		appDAO.save(instructor);
	}

	private void findInstructorById(AppDAO appDAO) {
		Instructor instructor = appDAO.findInstructorById(1);
		System.out.println(instructor);
	}

	private void findInstructorDetailById(AppDAO appDAO) {
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(2);
		Instructor instructor = instructorDetail.getInstructor();

		System.out.println(instructor);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		appDAO.deleteInstructorDetail(2);
	}

	private void deleteInstructorDetailNoCascade(AppDAO appDAO) {
		appDAO.deleteInstructorDetailNoCascade(1);
	}

	private void addSomeCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("Kay", "Ulu", "kay.ulu@example.de");
		InstructorDetail instructorDetail = new InstructorDetail("javaChannel", "Guitar");

		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Advanced Java Programming");
		Course course2 = new Course("Advanced Guitar");

		instructor.add(course1);
		instructor.add(course2);

		appDAO.save(instructor);
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = appDAO.findInstructorById(1);

		System.out.println("Instructor" + instructor);

		System.out.println("Courses: " + instructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		List<Course> courses = appDAO.findCoursesByInstructorId(1);

		System.out.println(courses);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(1);

		List<Course> courses = instructor.getCourses();

		System.out.println("Instructor: " + instructor);
		System.out.println("Courses: " + courses);
	}

	private void updateInstructor(AppDAO appDAO) {
		Instructor instructor = appDAO.findInstructorById(1);
		instructor.setFirstName("Kayhan");

		appDAO.update(instructor);
	}

	private void updateCourse(AppDAO appDAO) {
		Course course = appDAO.findCourseById(11);
		course.setTitle("Advanced Piano");

		appDAO.update(course);
	}


	private void deleteCourseById(AppDAO appDAO) {
		appDAO.deleteCourseById(10);
	}

	private void addReviewToCourse(AppDAO appDAO) {
		Course course = appDAO.findCourseById(11);

		course.addReview(new Review("Very good!"));

		course.addReview(new Review("Best course - ever!!!"));

		appDAO.save(course);
	}

	private void findCourseAndReview(AppDAO appDAO) {
		Course course = appDAO.findCourseAndReviewsByCourseId(10);
		System.out.println("Course: " + course);
		System.out.println("Reviews: " + course.getReviews());
	}

	private void createCourseWithStudents(AppDAO appDAO) {
		Course course = new Course("Python for Beginners");
		Student student1 = new Student("Nur", "Sam", "nur@sam.com");
		Student student2 = new Student("Ser", "Jo", "ser@jo.com");

		course.addStudent(student1);
		course.addStudent(student2);

		appDAO.saveNewCourseNewStudents(course);
	}

	private void findCourseAndStudentsByCourseId(AppDAO appDAO) {
		Course course = appDAO.findCourseAndStudentByCourseId(16);
		System.out.println("Course: " + course);
		System.out.println("Students: ");
		List<Student> students = course.getStudents();
		for(Student student : students)
			System.out.println("\t" + student);
	}

	private void findStudentAndCoursesByStudentId(AppDAO appDAO) {
		Student student = appDAO.findStudentAndCourseByStudentId(2);
		System.out.println("Student: " + student);
		System.out.println("Courses: ");
		List<Course> courses = student.getCourses();
		for(Course course : courses)
			System.out.println("\t" + course);
	}

	private void addCoursesToStudent(AppDAO appDAO) {
		Student student = appDAO.findStudentAndCourseByStudentId(2);
		Course course1 = new Course("Rubik's Cube - How to Speed Cube");
		Course course2 = new Course("Atari 2600 - Game Development");

		student.addCourse(course1);
		student.addCourse(course2);

		appDAO.update(student);
	}

	private void deleteStudentById(AppDAO appDAO) {
		appDAO.deleteStudentById(6);
	}
}
