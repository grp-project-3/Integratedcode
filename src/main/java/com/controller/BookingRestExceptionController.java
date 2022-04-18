package com.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BookingRestExceptionController {

		@ExceptionHandler(DeleteBookingException.class)
	    public ResponseEntity<?> handleDeleteException(DeleteBookingException e,WebRequest req)
	    {
		
			
			  return new ResponseEntity<>(e.toString(),HttpStatus.NOT_FOUND);
			
	    }
	}

