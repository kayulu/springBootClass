package com.kayulu.springcruddemo.dao;

import com.kayulu.springcruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional  // Spring will handle transaction management
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // Do not forget: JPQL queries operate on entity objects and not database rows
        TypedQuery<Student> query = entityManager.createQuery("FROM Student order by firstName desc", Student.class);

        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery("FROM Student WHERE lastName=:param", Student.class);

        return query.setParameter("param", lastName).getResultList();
    }

    @Override
    @Transactional  // updates database -> it must be executed in a managed transaction
    public void updateStudent(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Student student) {
        // student is detached and needs to be attached again
        // it only serves to retrieve the id of the student
        Student student1 = entityManager.find(Student.class, student.getId());
        // at this point the student is managed and can be removed from the context and the database
        entityManager.remove(student1);
        // this is only for demonstrating purposes
    }

    @Override
    public boolean isManaged(Student theStudent) {
        return entityManager.contains(theStudent);
    }
}
