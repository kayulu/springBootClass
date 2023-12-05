package com.kayulu.restdatabasecrud.dao;

import com.kayulu.restdatabasecrud.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {
    private final EntityManager entityManager;

    public EmployeeDaoImpl(EntityManager entityManager) { // autowired
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee e", Employee.class);
        return query.getResultList();
    }
}
