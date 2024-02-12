package com.DerivedQuery_JPQL_prac.test.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.DerivedQuery_JPQL_prac.test.Entity.Employee;
import com.DerivedQuery_JPQL_prac.test.Service.EmployeeService;


@RestController
public class EmployeeController {


	@Autowired
	private EmployeeService eService;
	
	
	@GetMapping("/employees")
	public List<Employee> getEmployees() {
		return eService.getAllEmployees();
	}
	
	@GetMapping("/employeeSW")
	public List<Employee> getEmployeesStartingWith(@RequestParam String prefix)
	{
		return eService.getAllEmployeesStartingWith(prefix);
	}
	
	@GetMapping("employees/{id}")
	public Employee getEmployee(@PathVariable("id") Long id) {
		return eService.getEmployee(id);
	}
	
	@PostMapping("/employees")
	public Employee saveEmployee( @RequestBody Employee employee) {
		return eService.saveEmployee(employee);
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		employee.setId(id);
		return eService.updateEmployee(employee);
	}
	
	@DeleteMapping("/employees")
	public String deleteEmployee(@RequestParam("id") Long id) {
		eService.deleteById(id);
		return "deleted Employee with id "+id;
	}
}
