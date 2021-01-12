package com.abc.springdemo.StudentExceptionHandler;

public class StudentRecordNotFoundException extends RuntimeException {

	public StudentRecordNotFoundException(String message) {
		super(message);
	}

}
