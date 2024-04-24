package com.kayulu.springbootAdvancedMappings;

import com.kayulu.springbootAdvancedMappings.dao.AppDAO;
import com.kayulu.springbootAdvancedMappings.entity.Course;
import com.kayulu.springbootAdvancedMappings.entity.Instructor;
import com.kayulu.springbootAdvancedMappings.entity.InstructorDetail;
import com.kayulu.springbootAdvancedMappings.entity.Review;
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

//		return runner -> findCourseAndReview(appDAO);

		return runner -> deleteCourseById(appDAO);
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
		Course course = appDAO.findCourseById(10);

		course.addReview(new Review("Very good!"));

		appDAO.save(course);
	}

	private void findCourseAndReview(AppDAO appDAO) {
		Course course = appDAO.findCourseAndReviewsByCourseId(10);
		System.out.println("Course: " + course);
		System.out.println("Reviews: " + course.getReviews());
	}
}
