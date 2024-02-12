package com.RESTapi.test.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.RESTapi.test.model.Employee;

@DataJpaTest
public class EmployeeRepositoryTest {
 
	// given - when - then
	
	@Autowired
	private EmployeeRepository employeeRepository;
	Employee employee;
	
	
	@BeforeEach
	void setUp() {
		employee = new Employee(0L,"Kritarth",32L,"Azamgarh","kritarth@gmail.com","IT");
		employeeRepository.save(employee);
	}
	
	@AfterEach
	void tearDown() {
		employee = null;
		employeeRepository.deleteAll();
	}
	@Test
	void FindByDepartment_Test() {
		List<Employee> employeeList = employeeRepository.findByDepartment("IT");
		assertThat(employeeList.get(0).getId()).isEqualTo(employee.getId());
	}
	
}
