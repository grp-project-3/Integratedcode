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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.AdminService;
import com.dao.FareService;
import com.dao.FleetService;
import com.dao.FlightService;
import com.dao.LocationService;
import com.flightPackage.Admin;
import com.flightPackage.AdminDashboard;
import com.flightPackage.Fare;
import com.flightPackage.Fleet;
import com.flightPackage.Flight;
import com.flightPackage.Location;

@RestController
public class AdminDashboardController 
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
	
	// admin flight dashboard changes
	  
	  @GetMapping("/admin/getflight/{id}")
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
		
		@GetMapping("/admin/getallflight")
	 public List<Flight> getAllFlight()
	 {
		   return flightService.findAll();
	 }
		   
	 @PostMapping("/admin/addflight")
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
	 
	 @DeleteMapping("/admin/deleteflight/{id}")
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
	 
	 @PatchMapping("/admin/updateflight")
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
	 
	 // admin fare dashboard changes
	 
	 @DeleteMapping("/admin/deletelocation/{id}")
	 public ResponseEntity<?> deleteLocation(@PathVariable("id") int id) throws DeleteLocationException 
	 {
		   Location location= locationService.find(id);
		   if(location==null)
		   {
			   throw new DeleteLocationException(id);
		   }
		   locationService.delete(id);
		   return ResponseEntity.ok("Flight location details deleted successfully");
	 }
	 
	 @PatchMapping("/admin/updatelocation")
	 public ResponseEntity<?> updateLocation(@RequestBody Location location) throws UpdateLocationException
	 {
		   Location location1= locationService.find(location.getId());
		   if(location1==null)
		   {
			   throw new UpdateLocationException();
		   }
		   locationService.update(location);
		   return ResponseEntity.ok("Flight location details updated Successfully");
	 }
	 
	 // admin fleet dashboard changes
	 
	 @DeleteMapping("/admin/deletefeett/{id}")
	 public ResponseEntity<?> deleteFeett(@PathVariable("id") int id) throws DeleteFleetException 
	 {
		   Fleet fleet = fleetService.find(id);
		   if(fleet==null)
		   {
			   throw new DeleteFleetException(id);
		   }
		   fleetService.delete(id);
		   return ResponseEntity.ok("Fleet details deleted successfully");
	 }
	 
	 @PatchMapping("/admin/updatefleet")
	 public ResponseEntity<?> updateFleet(@RequestBody Fleet fleet) throws UpdateFleetException
	 {
		   Fleet fleet1 = fleetService.find(fleet.getId());
		   if(fleet1==null)
		   {
			   throw new UpdateFleetException();
		   }
		   fleetService.update(fleet);
		   return ResponseEntity.ok("Fleet details updated Successfully");
	 }
	 
	 // admin fare dashboard changes
	 
	 @DeleteMapping("/admin/deletefare/{id}")
	 public ResponseEntity<?> deleteFare(@PathVariable("id") int id) throws DeleteFareException
	 {
		   Fare fare= fareService.find(id);
		   if(fare==null)
		   {
			   throw new DeleteFareException(id);
		   }
		   fareService.delete(id);
		   return ResponseEntity.ok(" Flight Fare details deleted successfully");
	 }
	 
	 @PatchMapping("/admin/updatefare")
	 public ResponseEntity<?> updateFare(@RequestBody Fare fare) throws UpdateFareException
	 {
		   Fare fare1 = fareService.find(fare.getId());
		   if(fare1==null)
		   {
			   throw new UpdateFareException();
		   }
		   fareService.modifyFare(fare);
		   return ResponseEntity.ok("Flight fare details updated Successfully");
	 }
}
