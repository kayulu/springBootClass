package com.kayulu.springcruddemo.dao;

import com.kayulu.springcruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
    List<Student> findAll();
    List<Student> findByLastName(String match);
    void updateStudent(Student student);
    void deleteStudent(Student student);
    void deleteStudent(Integer id);
    int deleteAll();

    boolean isManaged(Student theStudent);
}
