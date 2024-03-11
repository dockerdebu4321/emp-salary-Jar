package com.ey.practice.SpringBootPractice.exception;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.ey.practice.SpringBootPractice.bean.ErrorResponse;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {
	
	private static final Logger log = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);

	@ExceptionHandler(SystemDownException.class)
	public ResponseEntity<Object> handleSystemDownException(Exception e, WebRequest request) {
		ErrorResponse errRes = new ErrorResponse(8,e.getMessage());
		return new ResponseEntity<>(errRes, HttpStatus.OK);
	}
	//NoResourceFoundException
	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<Object> handleNoResourceFoundException(Exception e, WebRequest request) {
		ErrorResponse errRes = new ErrorResponse(404,"Please enter a valid URL");
		return new ResponseEntity<>(errRes, HttpStatus.OK);
	}
	//MethodArgumentTypeMismatchException
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(Exception e, WebRequest request) {
		ErrorResponse errRes = new ErrorResponse(400,"Please enter a valid Input parameter");
		return new ResponseEntity<>(errRes, HttpStatus.OK);
	}
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<Object> handleEmployeeNotFoundException(Exception e, WebRequest request) {
		ErrorResponse errRes = new ErrorResponse(9,e.getMessage());
		return new ResponseEntity<>(errRes, HttpStatus.OK);
	}
	//MissingServletRequestParameterException
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<Object> handleMissingServletRequestParameterException(Exception e, WebRequest request) {
		ErrorResponse errRes = new ErrorResponse(9,"Please enter Required fields in the url");
		return new ResponseEntity<>(errRes, HttpStatus.OK);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleEmployee(Exception e, WebRequest request) {
		ErrorResponse errRes = new ErrorResponse(10,e.getMessage());
		return new ResponseEntity<>(errRes, HttpStatus.OK);
	}
}
