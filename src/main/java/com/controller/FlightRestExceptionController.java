package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class FlightRestExceptionController 
{
	@ExceptionHandler(DeleteFlightException.class)
    public ResponseEntity<?> handleDeleteException(DeleteFlightException e,WebRequest req)
    {
		return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);		
    }
	
	@ExceptionHandler(UpdateFlightException.class)
    public ResponseEntity<?> handleUpdateException(UpdateFlightException e1,WebRequest req1)
    {
		return new ResponseEntity<>(e1.toString(),HttpStatus.NOT_FOUND);		
    }
	
	@ExceptionHandler(FindFlightException.class)
    public ResponseEntity<?> handleFindException(FindFlightException e2,WebRequest req2)
    {
		return new ResponseEntity<>(e2.toString(),HttpStatus.NOT_FOUND);		
    }
	
	@ExceptionHandler(AddFlightException.class)
    public ResponseEntity<?> handleAddException(AddFlightException e3,WebRequest req3)
    {
		return new ResponseEntity<>(e3.toString(),HttpStatus.NOT_FOUND);		
    }
	
	@ExceptionHandler(DeleteFleetException.class)
    public ResponseEntity<?> handleDeleteException(DeleteFleetException e4,WebRequest req4)
    {
		return new ResponseEntity<>(e4.toString(),HttpStatus.NOT_FOUND);		
    }
	
	@ExceptionHandler(UpdateFleetException.class)
    public ResponseEntity<?> handleUpdateException(UpdateFleetException e5,WebRequest req5)
    {
		return new ResponseEntity<>(e5.toString(),HttpStatus.NOT_FOUND);		
    }
	
	@ExceptionHandler(DeleteFareException.class)
    public ResponseEntity<?> handleDeleteException(DeleteFareException e6,WebRequest req6)
    {
		return new ResponseEntity<>(e6.toString(),HttpStatus.NOT_FOUND);		
    }
	
	@ExceptionHandler(UpdateFareException.class)
    public ResponseEntity<?> handleUpdateException(UpdateFareException e7,WebRequest req7)
    {
		return new ResponseEntity<>(e7.toString(),HttpStatus.NOT_FOUND);		
    }
	
	@ExceptionHandler(DeleteLocationException.class)
    public ResponseEntity<?> handleDeleteException(DeleteLocationException e8,WebRequest req8)
    {
		return new ResponseEntity<>(e8.toString(),HttpStatus.NOT_FOUND);		
    }
	
	@ExceptionHandler(UpdateLocationException.class)
    public ResponseEntity<?> handleUpdateException(UpdateLocationException e9,WebRequest req9)
    {
		return new ResponseEntity<>(e9.toString(),HttpStatus.NOT_FOUND);		
    }
}
