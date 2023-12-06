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

    @Override
    public Employee findById(int id) {
//        return entityManager.find(Employee.class, id);

        // for the sake of using a TypedQuery with params
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee e WHERE e.id = :id", Employee.class);
        query.setParameter("id", id);

        return query.getSingleResult();
    }

    @Override
    public void save(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
