package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.AdminService;
import com.dao.FareService;
import com.dao.FleetService;
import com.dao.FlightService;
import com.dao.LocationService;
import com.flightPackage.Admin;
import com.flightPackage.Flight;

@RestController
public class FlightController
{
	@Autowired
	FlightService flightService;
	
	@Autowired
	AdminService adminService;
	
	@Autowired
	FleetService fleetService;
	
	@Autowired
	FareService fareService;
	
	@Autowired
	LocationService locationService;
	
	// flight service
	@GetMapping("/getflight/{id}")
	public ResponseEntity<?> getFlight(@PathVariable int id) throws FindFlightException
	{
		Flight flight=flightService.find(id);
		if(flight==null)
		{
			throw new FindFlightException(id);
		}
		flightService.find(id);
		return ResponseEntity.ok("Flight found seccessfully");
	}
	
	@GetMapping("/getallflight")
   public List<Flight> getAllFlight()
   {
	   return flightService.findAll();
   }
	   
   @PostMapping("/addflight")
   public ResponseEntity<?> addFlight(@RequestBody Flight flight) throws AddFlightException
   {
	   if(flight.getArrivalLocation()==null || flight.getDepartureLocation()==null || flight.getFleet()==null || flight.getArrivalTime()==null
			   || flight.getDepartureTime()==null)
	   {
		   throw new AddFlightException();
	   }
	   flightService.add(flight);
	   return ResponseEntity.status(HttpStatus.OK).body("Flight added successfully");
   }
   
   @DeleteMapping("/deleteflight/{id}")
   public ResponseEntity<?> deleteFlight(@PathVariable("id") int id) throws DeleteFlightException 
   {
	   Flight flight = flightService.find(id);
	   if(flight==null)
	   {
		   throw new DeleteFlightException(id);
	   }
	   flightService.delete(id);
	   return ResponseEntity.ok("Flight details deleted successfully");
   }
   
   @PatchMapping("/updateflight")
   public ResponseEntity<?> updateFlight(@RequestBody Flight flight) throws UpdateFlightException
   {
	   Flight flight1 = flightService.find(flight.getId());
	   if(flight1==null)
	   {
		   throw new UpdateFlightException();
	   }
	   flightService.update(flight);
	   return ResponseEntity.ok("Flight details updated Successfully");
   }
   // admin details
   
   @GetMapping("/getadmin/{id}")
	public ResponseEntity<?> getAdmin(@PathVariable int id) throws FindAdminException
	{
		Admin admin=adminService.find(id);
		if(admin==null)
		{
			throw new FindFlightException(id);
		}
		adminService.find(id);
		return ResponseEntity.ok("Admin found seccessfully");
	}
	
	@GetMapping("/getalladmin")
  public List<Admin> getAllAdmin()
  {
	   return adminService.findAll();
  }
	   
  @PostMapping("/addadmin")
  public ResponseEntity<?> addAdmin(@RequestBody Admin admin) throws AddAdminException
  {
	   if(admin.getUserName()==null || admin.getPassword()==null)
	   {
		   throw new AddAdminException();
	   }
	   adminService.add(admin);
	   return ResponseEntity.status(HttpStatus.OK).body("Admin added successfully");
  }
  
  @DeleteMapping("/deleteadmin/{id}")
  public ResponseEntity<?> deleteAdmin(@PathVariable("id") int id) throws DeleteAdminException 
  {
	   Admin admin= adminService.find(id);
	   if(admin==null)
	   {
		   throw new DeleteAdminException(id);
	   }
	   adminService.delete(id);
	   return ResponseEntity.ok("Admin details deleted successfully");
  }
  
  @PatchMapping("/updateadmin")
  public ResponseEntity<?> updateAdmin(@RequestBody Admin admin) throws UpdateAdminException
  {
	   Admin admin1= adminService.find(admin.getId());
	   if(admin1==null)
	   {
		   throw new UpdateAdminException();
	   }
	   adminService.update(admin);
	   return ResponseEntity.ok("admin details updated Successfully");
  }
}
