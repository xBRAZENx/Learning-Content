package com.RESTapi.test.exception;

public class EmployeeNotFoundException extends RuntimeException{
	
	public EmployeeNotFoundException() {
		
		super();
	}
public EmployeeNotFoundException(String message) {
		
		super(message);
	}

}
