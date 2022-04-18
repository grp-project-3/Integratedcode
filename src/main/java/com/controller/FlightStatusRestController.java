package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.FareService;
import com.dao.FlightStatusService;
import com.model.Fare;
import com.model.FlightStatus;

@RestController
public class FlightStatusRestController {
	
	@Autowired
	FlightStatusService service;
	FareService servise;
	
	@GetMapping("/getflightstatus")
	public List<FlightStatus> getAllFlightStatus()
	{
		return service.findAll();
	}
	
	@PostMapping("/addflightstatus")
	public ResponseEntity<?> addFlightStatus(@RequestBody FlightStatus status)
	{
		service.add(status);
	//	return ResponseEntity.ok("FlightStatus added successfully");
		return ResponseEntity.status(HttpStatus.OK).body("Entity status added successfully");
	}
	
	@DeleteMapping("/deleteflightstatus/{id}")
	public ResponseEntity<?> deleteFlightStatus(@PathVariable int id) throws DeleteFlightException
	{
		FlightStatus status=service.find(id);
		if(status==null)
		{
			throw new DeleteFlightException(id);
		}
		service.delete(id);
		return ResponseEntity.ok("status deleted successfully");
	}
	
}
