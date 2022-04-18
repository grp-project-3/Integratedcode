package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class UserRestExceptionController {
	@ExceptionHandler(DeleteUserException.class)
    public ResponseEntity<?> handleDeleteException(DeleteUserException e,WebRequest req)
    {
	
		
		  return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
		
    }
	
	@ExceptionHandler(UpdateUserException.class)
    public ResponseEntity<?> handleUpdateException(UpdateUserException e,WebRequest req)
    {
	
		
		  return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
		
    }
	
	
}


