package com.RESTapi.test.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RESTapi.test.exception.EmployeeNotFoundException;
import com.RESTapi.test.model.Employee;
import com.RESTapi.test.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepository eRepository;
	
	@Override
	public List<Employee> getEmployees() {
		List<Employee> empList = eRepository.findAll();
		//Collections.sort(empList);
		 Collections.sort(empList,new Comparator<Employee>(){

			@Override
			public int compare(Employee o1, Employee o2) {
				return (int) (o1.getId()-o2.getId());
			}
			 
		 });
		 return empList;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		return eRepository.save(employee);
	}

	@Override
	public Employee getEmployee(Long id){
		Optional<Employee> employee =  eRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}else throw new EmployeeNotFoundException("Employee not present for id "+id);
	}

	@Override
	public void deleteEmployee(Long id) {
		eRepository.deleteById(id);
		
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		return eRepository.save(employee);
	}

}
