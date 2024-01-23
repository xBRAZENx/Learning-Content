package com.atharva.TestPrograms;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.atharva.TestPrograms.*;

public class EmpCounter {

	public static void main(String[]args) {
		Employee emp1 = new Employee("Atharva","IT");
		Employee emp2 = new Employee("Samay","Marketing");
		Employee emp3 = new Employee("Aditya","R&D");
		Employee emp4 = new Employee("Ajay","IT");
		Employee emp5 = new Employee("Dev","IT");
		Employee emp6 = new Employee("Rajan","IT");
		List<Employee> list1 = Arrays.asList(
				emp1,emp2,emp3,emp4,emp5,emp6);
		
		 Long count = list1.stream().filter(emp -> emp.getBackground()=="IT").collect(Collectors.counting());
		 
		 System.out.println(count);
		
}}
