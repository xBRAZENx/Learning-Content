package com.Searching.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService eService;
	
	private static List<Employee> employees = new ArrayList<>();
    
    Department engineeringDept = new Department(101, "Engineering");
    Department marketingDept = new Department(102, "Marketing");
    {
    employees.add(new Employee(1, "Vinit Singh", "Manager", engineeringDept));
    employees.add(new Employee(2, "Atharva Gupta", "Developer", marketingDept));
    employees.add(new Employee(3, "Akarsh", "Analyst", engineeringDept));
    }
    
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
    	return employees;
    }
    
	@GetMapping("/employee/{empId}")
    public Employee getEmployeeDetails(@PathVariable int empId) {
        return eService.getEmployeeById(employees, empId);
    }

    @GetMapping("/employeeExists/{empId}")
    public boolean doesEmployeeExist(@PathVariable int empId) {
        return eService.isEmployeePresentById(employees, empId);
    }
    
    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee newEmployee){
    	 eService.addEmployeeToList(employees, newEmployee);
    	 return newEmployee;
    }

    @GetMapping("/employeesByDesignation/{designation}")
    public List<Employee> getEmployeesByDesignation(@PathVariable String designation) {
        return eService.getEmployeesByDesignation(employees, designation);
    }

    @GetMapping("/employeesByDepartment/{deptId}")
    public List<Employee> getEmployeesByDepartment(@PathVariable int deptId) {
        return eService.getEmployeesByDepartment(employees, deptId);
    }

    @DeleteMapping("/deleteEmployee/{empId}")
    public List<Employee> deleteEmployee(@PathVariable int empId) {
        return eService.deleteEmployeeById(employees, empId);
        }
    }

