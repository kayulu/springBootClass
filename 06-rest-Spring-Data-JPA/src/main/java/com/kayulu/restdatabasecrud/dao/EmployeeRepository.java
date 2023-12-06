package com.kayulu.restdatabasecrud.dao;

import com.kayulu.restdatabasecrud.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
