package com.kayulu.springbootOneToOneMapping;

import com.kayulu.springbootOneToOneMapping.dao.AppDAO;
import com.kayulu.springbootOneToOneMapping.entity.Course;
import com.kayulu.springbootOneToOneMapping.entity.Instructor;
import com.kayulu.springbootOneToOneMapping.entity.InstructorDetail;
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
//		return runner -> {saveInstructor(appDAO);};
//		return runner -> {findInstructorById(appDAO);};
//		return runner -> {removeInstructorById(appDAO);};

//		return runner -> {findInstructorDetailById(appDAO);};
//		return runner -> {deleteInstructorDetail(appDAO);};

//		return runner -> {deleteInstructorDetailNoCascade(appDAO);};

//		return runner -> {addSomeCourses(appDAO);};

//		return runner -> {findInstructorWithCourses(appDAO);};

//		return runner -> {findCoursesForInstructor(appDAO);};

//		return runner -> findInstructorWithCoursesJoinFetch(appDAO);

//		return runner -> updateInstructor(appDAO);

		return runner -> updateCourse(appDAO);
	}


	private void removeInstructorById(AppDAO appDAO) {
		appDAO.deleteInstructor(2);
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
}
