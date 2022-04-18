package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.dao.BookingService;
import com.model.*;
@RestController
public class UserDashboardRestController {

	
	
		@Autowired
	BookingService service;
	  
		   @GetMapping("/getbooking")
		   public List<Booking> getAllBookings()
		   {
			   return service.findAllBooking();
		   }
		   
		   @PostMapping("/addbooking")
		   public ResponseEntity<?> addBooking(@RequestBody Booking booking)
		   {
			service.add(booking);
			return ResponseEntity.status(HttpStatus.OK).body("Entity booking done success fully");
		   }
		   
		   @DeleteMapping("/deletebooking/{id}")
		   public ResponseEntity<?> deleteBooking(@PathVariable int id)throws DeleteBookingException 
		   {
			   Booking booking=service.find(id);
			   if(booking==null)
			   {
				    throw new DeleteBookingException(id);
			   }
			
			     	   service.delete(id);   
			      return ResponseEntity.ok("booking deleted successfully");
		   }
		   

	}

