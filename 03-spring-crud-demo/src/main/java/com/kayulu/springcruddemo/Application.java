package com.kayulu.springcruddemo;

import com.kayulu.springcruddemo.dao.StudentDAO;
import com.kayulu.springcruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDao) {
		return runner -> {
			createStudent(studentDao);
		};
	}

	private void createStudent(StudentDAO studentDao) {
		Student student = new Student();
		student.setFirstName("Kay");
		student.setLastName("Ulu");
		student.setEmail("kay@ulu.de");

		studentDao.save(student);
	}
}
