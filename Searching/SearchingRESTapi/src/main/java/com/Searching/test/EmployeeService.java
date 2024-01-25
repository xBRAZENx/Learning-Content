package com.Searching.test;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	public Employee getEmployeeById(List<Employee> employees, int empId) {
        return employees.stream()
                .filter(employee -> employee.getEmpId() == empId)
                .findFirst()
                .orElseThrow(()-> new EmployeeNotFoundException("Employee with ID " + empId + " not found"));
    }

    public boolean isEmployeePresentById(List<Employee> employees, int empId) {
        return employees.stream().anyMatch(employee -> employee.getEmpId() == empId);
    }

    public Employee addEmployeeIfAbsent(List<Employee> employees, Employee newEmployee) {
    	
        if (employees.stream().anyMatch(employee -> employee.getEmpId() == newEmployee.getEmpId())) {
            throw new EmployeeAlreadyExistsException("Employee with ID " + newEmployee.getEmpId() + " already exists");
        }
        employees.add(newEmployee);
        return newEmployee;
    }

    public List<Employee> getEmployeesByDesignation(List<Employee> employees, String designation) {
        return employees.stream()
                .filter(employee -> employee.getDesignation().equals(designation))
                .collect(Collectors.toList());
    }

    public List<Employee> getEmployeesByDepartment(List<Employee> employees, int targetDepartment) {
        return employees.stream()
                .filter(employee -> employee.getDepartment().getDeptId()==targetDepartment)
                .collect(Collectors.toList());
    }

    public List<Employee> deleteEmployeeById(List<Employee> employees, int empId) {
        if (!employees.removeIf(employee -> employee.getEmpId() == empId)) {
            throw new EmployeeNotFoundException("Employee with ID " + empId + " not found for deletion");
        }
        return employees;
    }

    public List<Employee> addEmployeeToList(List<Employee> employees, Employee newEmployee) {
        if (employees.contains(newEmployee)) {
            throw new EmployeeAlreadyExistsException("Employee with ID " + newEmployee.getEmpId() + " already exists");
        }
        employees.add(newEmployee);
        return employees;
    }
}
