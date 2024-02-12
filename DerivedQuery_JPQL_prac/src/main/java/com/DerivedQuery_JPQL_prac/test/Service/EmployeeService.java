package com.DerivedQuery_JPQL_prac.test.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DerivedQuery_JPQL_prac.test.Entity.Employee;
import com.DerivedQuery_JPQL_prac.test.Repository.EmployeeRepository;


@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository emprepo;
	
	public List<Employee> getAllEmployees()
    {
        List<Employee> EmployeeList = emprepo.findAll();
        return EmployeeList;
    }
 
    public Employee saveEmployee(Employee employee)
    {
        return emprepo.save(employee);
    }

    public Employee getEmployee(long id)
    {
        Employee newEmployee = null;
        Optional<Employee> employee = emprepo.findById(id);
        if(employee.isPresent())
        {
            newEmployee = employee.get();
        }
        return newEmployee;
    }

    public List<Employee> getAllEmployeesStartingWith(String prefix)
    {
    	return emprepo.findByNameStartingWithIgnoreCase(prefix);
    }
    
    public Employee updateEmployee(Employee employee) {
    	return emprepo.save(employee);
    }
    
    public String deleteById(long id)
    {
        emprepo.deleteById(id);
        return "Deleted Allergy with id "+id;
    }
	
}
