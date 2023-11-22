package com.kayulu.springcruddemo.dao;

import com.kayulu.springcruddemo.entity.Student;

public interface StudentDAO {
    void save(Student student);
    Student findById(Integer id);
}
