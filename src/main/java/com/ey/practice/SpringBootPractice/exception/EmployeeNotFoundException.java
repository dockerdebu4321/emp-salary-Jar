package com.ey.practice.SpringBootPractice.exception;

public class EmployeeNotFoundException extends RuntimeException{

	public EmployeeNotFoundException(String errorMessage) {
		super(errorMessage);
		// TODO Auto-generated constructor stub
	}

}
