package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.FareService;
import com.model.Fare;
import com.model.FlightStatus;

@RestController
public class TicketFareRestController {
	
	@Autowired
	FareService service;
	
	@GetMapping("/getfare")
	public List<Fare> getAllFare()
	{
		return service.findAll();
	}
	
	@PostMapping("/addfare")
	public ResponseEntity<?> addFare(@RequestBody Fare fare)
	{
		service.add(fare);
	//	return ResponseEntity.ok("Fare added successfully");
		return ResponseEntity.status(HttpStatus.OK).body("TicketFare added successfully");
	}
	
	@PatchMapping("/modifyfare")
	public ResponseEntity<?> modifyFare(@RequestBody Fare fare)
	{
		service.modifyFare(fare);
		return ResponseEntity.ok("Fare modified successfully");
	}
	@DeleteMapping("/deletefare/{id}")
	public ResponseEntity<?> deleteFare(@PathVariable int id) throws DeleteFareException
	{
		Fare status=service.find(id);
		if(status==null)
		{
			throw new DeleteFareException(id);
		}
		service.delete(id);
		return ResponseEntity.ok("fare deleted successfully");
	}

}
