package com.atharva.Searching;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

	public static Employee getEmployeeById(List<Employee> employees, int empId) {
        return employees.stream()
                .filter(employee -> employee.getEmpId() == empId)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + empId + " not found"));
    }

    public static boolean isEmployeePresentById(List<Employee> employees, int empId) {
        return employees.stream().anyMatch(employee -> employee.getEmpId() == empId);
    }

    public static Employee addEmployeeIfAbsent(List<Employee> employees, Employee newEmployee) {
    	
        if (employees.stream().anyMatch(employee -> employee.getEmpId() == newEmployee.getEmpId())) {
            throw new EmployeeAlreadyExistsException("Employee with ID " + newEmployee.getEmpId() + " already exists");
        }
        employees.add(newEmployee);
        return newEmployee;
    }

    public static List<Employee> getEmployeesByDesignation(List<Employee> employees, String designation) {
        return employees.stream()
                .filter(employee -> employee.getDesignation().equals(designation))
                .collect(Collectors.toList());
    }

    public static List<Employee> getEmployeesByDepartment(List<Employee> employees, String targetDepartment) {
        return employees.stream()
                .filter(employee -> employee.getDepartment().getDeptName().equals(targetDepartment))
                .collect(Collectors.toList());
    }

    public static List<Employee> deleteEmployeeById(List<Employee> employees, int empId) {
        if (!employees.removeIf(employee -> employee.getEmpId() == empId)) {
            throw new EmployeeNotFoundException("Employee with ID " + empId + " not found for deletion");
        }
        return employees;
    }

    public static List<Employee> addEmployeeToList(List<Employee> employees, Employee newEmployee) {
        if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyExistsException("Employee with ID " + newEmployee.getEmpId() + " already exists");
        }
        employees.add(newEmployee);
        return employees;
    }
	
    public static void main(String[] args) {

		 List<Employee> employees = new ArrayList<>();
	        
	        Department engineeringDept = new Department(101, "Engineering");
	        Department marketingDept = new Department(102, "Marketing");

	        employees.add(new Employee(1, "Vinit Singh", "Manager", engineeringDept));
	        employees.add(new Employee(2, "Atharva Gupta", "Developer", marketingDept));
	        employees.add(new Employee(3, "Akarsh", "Analyst", engineeringDept));

	        
	        System.out.println("Employees: " + employees);
	        
	        
	        Employee employeeById = getEmployeeById(employees, 2);
           System.out.println("Employee by ID: " + employeeById);

           boolean isEmployeePresent = isEmployeePresentById(employees, 3);
           System.out.println("Is Employee present: " + isEmployeePresent);

           Employee newEmployee = new Employee(4, "Khushi", "Designer", engineeringDept);
           Employee addedEmployee = addEmployeeIfAbsent(employees, newEmployee);
           System.out.println("Added Employee: " + addedEmployee);

           List<Employee> employeesByDesignation = getEmployeesByDesignation(employees, "Developer");
           System.out.println("Employees by Designation: " + employeesByDesignation);

           List<Employee> employeesInEngineering = getEmployeesByDepartment(employees, "Engineering");
           System.out.println("Employees in Engineering: " + employeesInEngineering);

           List<Employee> updatedEmployeeListAfterDeletion = deleteEmployeeById(employees, 1);
           System.out.println("Employee list after deletion: " + updatedEmployeeListAfterDeletion);
           
           Employee newEmployeeToAdd = new Employee(5, "Princy", "Analyst", engineeringDept);
           List<Employee> updatedEmployeeListAfterAddition = addEmployeeToList(employees, newEmployeeToAdd);
           System.out.println("Employee List After Addition:" + updatedEmployeeListAfterAddition);
    }
}
