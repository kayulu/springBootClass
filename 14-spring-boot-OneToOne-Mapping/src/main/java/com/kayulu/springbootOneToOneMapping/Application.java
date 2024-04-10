package com.kayulu.springbootOneToOneMapping;

import com.kayulu.springbootOneToOneMapping.dao.AppDAO;
import com.kayulu.springbootOneToOneMapping.entity.Instructor;
import com.kayulu.springbootOneToOneMapping.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

		return runner -> {deleteInstructorDetailNoCascade(appDAO);};
	}

	private void removeInstructorById(AppDAO appDAO) {
		appDAO.deleteInstructor(1);
	}

	private void saveInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("Ser", "Jo", "ser.jo@example.de");
		InstructorDetail instructorDetail = new InstructorDetail("herChannel", "fashion");

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
}
