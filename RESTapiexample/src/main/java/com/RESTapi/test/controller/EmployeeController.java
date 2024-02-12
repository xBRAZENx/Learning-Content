package com.RESTapi.test.controller;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.RESTapi.test.model.Employee;
import com.RESTapi.test.service.EmployeeService;

import jakarta.validation.Valid;

//@Controller
@RestController //@Controller + @ResponseBody
public class EmployeeController {
	
	@Autowired
	private EmployeeService eService;
	
	//@RequestMapping(value="/employees",method=RequestMethod.GET)
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return eService.getEmployees();
	}
	
	//localhost:8080/employees/12
	@GetMapping("employees/{id}")
	public Employee getEmployee(@PathVariable("id") Long id) {
		return eService.getEmployee(id);
	}
	
	@PostMapping("/employees")
	public Employee saveEmployee(@Valid @RequestBody Employee employee) {
		return eService.saveEmployee(employee);
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		employee.setId(id);
		return eService.updateEmployee(employee);
	}
	
	@DeleteMapping("/employees")
	public String deleteEmployee(@RequestParam("id") Long id) {
		eService.deleteEmployee(id);
		return "deleted Employee with id "+id;
	}
	
	
	
}
