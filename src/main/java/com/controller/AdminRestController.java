package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AdminRestController 
{
	@ExceptionHandler(DeleteAdminException.class)
    public ResponseEntity<?> handleDeleteException(DeleteAdminException e,WebRequest req)
    {
		return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);		
    }
	
	@ExceptionHandler(UpdateAdminException.class)
    public ResponseEntity<?> handleUpdateException(UpdateAdminException e1,WebRequest req1)
    {
		return new ResponseEntity<>(e1.toString(),HttpStatus.NOT_FOUND);		
    }
	
	@ExceptionHandler(FindAdminException.class)
    public ResponseEntity<?> handleFindException(FindAdminException e2,WebRequest req2)
    {
		return new ResponseEntity<>(e2.toString(),HttpStatus.NOT_FOUND);		
    }
	
	@ExceptionHandler(AddAdminException.class)
    public ResponseEntity<?> handleAddException(AddAdminException e3,WebRequest req3)
    {
		return new ResponseEntity<>(e3.toString(),HttpStatus.NOT_FOUND);		
    }
}
