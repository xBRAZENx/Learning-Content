package com.RESTapi.test.service;

import java.util.List;

import com.RESTapi.test.model.Employee;

public interface EmployeeService {

	List<Employee> getEmployees();
	
	Employee saveEmployee(Employee employee);
	
	Employee getEmployee(Long id);
	
	void deleteEmployee(Long id);
	
	Employee updateEmployee (Employee employee);
}
