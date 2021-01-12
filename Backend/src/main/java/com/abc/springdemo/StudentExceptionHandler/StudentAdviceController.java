package com.abc.springdemo.StudentExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentAdviceController {

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentRecordNotFoundException exception) {

		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {

		StudentErrorResponse errorResponse = new StudentErrorResponse();
		errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
		errorResponse.setMessage("Plz provide a int value only");
		errorResponse.setTimeStamp(System.currentTimeMillis());

		return new ResponseEntity<StudentErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);

	}

}
