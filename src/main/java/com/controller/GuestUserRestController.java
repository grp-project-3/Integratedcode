package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Dao.LocationService;
import com.model.Location;

@RestController
public class GuestUserRestController {

	@Autowired
	LocationService service;
	
	@GetMapping("/getguestuser")
	public List<Location> getAllGuestUsers()
	{
		   return service.findAll();
	   }
	
	@PostMapping("/addguestuser")
	   public ResponseEntity<?> addGustUser(@RequestBody Location location)
	   {
		service.add(location);
		return ResponseEntity.status(HttpStatus.OK).body("Entity guestuser added successfully");
	   }
	   
	   @DeleteMapping("/deleteguestuser/{id}")
	   public ResponseEntity<?> deleteGuestUser(@PathVariable int id)throws DeleteGuestUserException 
	   {
		    Location location=service.find(id);
		   if(location==null)
		   {
			    throw new DeleteGuestUserException(id);
		   }
		      service.delete(id);   
		      return ResponseEntity.ok("element deleted successfully");
	   }
		   
		   @PatchMapping("/updateguestuser{id}")
		   public ResponseEntity<?> updateGuestUser(@RequestBody Location location)throws UpdateGuestUserException
		   {
			    Location location1=service.find(location.getId());
			   if(location==null)
			   {
				    throw new UpdateGuestUserException(1);
			   }
			   service.update(location);   
			      return ResponseEntity.ok("element updated successfully");
		   }
		  
		   
		}

