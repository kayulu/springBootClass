package com.kayulu.springbootOneToOneMapping;

import com.kayulu.springbootOneToOneMapping.dao.AppDAO;
import com.kayulu.springbootOneToOneMapping.dao.AppDAOImpl;
import com.kayulu.springbootOneToOneMapping.entity.Instructor;
import com.kayulu.springbootOneToOneMapping.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
			Instructor instructor = new Instructor("Ser", "Jo", "ser.jo@example.de");
			InstructorDetail instructorDetail = new InstructorDetail("herChannel", "fashion");

			instructor.setInstructorDetail(instructorDetail);

			appDAO.save(instructor);

		};
	}
}
