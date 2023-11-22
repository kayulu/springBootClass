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
//			createStudent(studentDao);
//			createMultipleStudents(studentDao);
			findStudent(studentDao);
		};
	}

	private void findStudent(StudentDAO studentDAO) {
		Student stud = new Student("Kay", "Ulu", "kay@ulu.de");
		studentDAO.save(stud);

		int id = stud.getId();

		System.out.println("Id: " + id);

		Student tempStud = studentDAO.findById(id);
		System.out.println(tempStud);

	}

	private void createMultipleStudents(StudentDAO studentDao) {
		Student student1 = new Student("Sel", "Kit", "sel@ulu.de");
		Student student2 = new Student("Sera", "Jo", "sera@ulu.de");
		Student student3 = new Student("Nur", "Sam", "nur@ulu.de");

		studentDao.save(student1);
		studentDao.save(student2);
		studentDao.save(student3);
	}

	private void createStudent(StudentDAO studentDao) {
		Student student = new Student();
		student.setFirstName("Kay");
		student.setLastName("Ulu");
		student.setEmail("kay@ulu.de");

		studentDao.save(student);
	}
}
