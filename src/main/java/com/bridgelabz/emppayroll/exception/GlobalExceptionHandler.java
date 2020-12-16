package com.bridgelabz.emppayroll.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bridgelabz.emppayroll.model.ErrorMessage;

@RestControllerAdvice
public class GlobalExceptionHandler extends Exception{

	@ExceptionHandler
	public ResponseEntity<ErrorMessage> handle(Exception ex) {
		if (ex instanceof EmployeePayrollException) {
			return new ResponseEntity<ErrorMessage>(new ErrorMessage(ex.getMessage(), 400), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ErrorMessage>(new ErrorMessage("failed to add the data", 500), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
