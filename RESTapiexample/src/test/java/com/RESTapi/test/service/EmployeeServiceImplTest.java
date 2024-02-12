package com.RESTapi.test.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.RESTapi.test.model.Employee;
import com.RESTapi.test.repository.EmployeeRepository;

public class EmployeeServiceImplTest {
	
	@Mock
	private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	
	AutoCloseable autoCloseable;
	Employee employee;
	
	@BeforeEach
	void setup() {
		autoCloseable = MockitoAnnotations.openMocks(this);
		employee = new Employee(0L,"Kritarth",32L,"Azamgarh","kritarth@gmail.com","IT");
	}
	
	@AfterEach
	void tearDown() throws Exception{
		autoCloseable.close();
	}
	
	 @Test
	    public void getEmployees_Test() {
	        
	        Employee employee1 = new Employee(0L,"Kritarth",32L,"Azamgarh","kritarth@gmail.com","IT");
	        Employee employee2 = new Employee(1L,"Aman",25L,"Lucknow","aman@gmail.com","Marketing");
	        List<Employee> expectedEmployees = new ArrayList<>();
	        expectedEmployees.add(employee1);
	        expectedEmployees.add(employee2);

	        
	        when(employeeRepository.findAll()).thenReturn(expectedEmployees);
	        
	        List<Employee> actualEmployees = employeeService.getEmployees();

	        assertThat(expectedEmployees).isEqualTo(actualEmployees);
	      
	    }


}
