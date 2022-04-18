package com.controller;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;
	import java.util.*;
	import com.dao.PassengerService;
import com.model.*;

@RestController
public class UserManageMyAccountRestController {

		@Autowired
		PassengerService service;

		   @GetMapping("/getpassengers")
		   public List<Passenger> getAllPassengers()
		   {
			   return service.findAll();
		   }

		   @PostMapping("/addpassenger")
		   public ResponseEntity<?> addPassenger(@RequestBody Passenger passenger)
		   {
			service.add(passenger);
			return ResponseEntity.status(HttpStatus.OK).body("Entity item added success fully");
		   }

		   @DeleteMapping("/deletepassenger/{id}")
		   public ResponseEntity<?> deletePassenger(@PathVariable int id)throws DeletePassengerException 
		   {
			   Passenger passenger=service.find(id);
			   if(passenger==null)
			   {
				    throw new DeletePassengerException(id);
			   }

			     	   service.delete(id);   
			      return ResponseEntity.ok("element deleted successfully");
		   }
		   
		   

}
