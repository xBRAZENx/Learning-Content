package com.RESTapi.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.RESTapi.test.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
List<Employee> findByDepartment(String department);
}
