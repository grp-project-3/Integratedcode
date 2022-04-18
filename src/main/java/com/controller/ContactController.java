package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.ContactService;
import com.model.Contact;
import com.model.User;

@RestController
public class ContactController {

	@Autowired
	ContactService contactservice;
	
	@PostMapping("/addcontact")
	public ResponseEntity<?> addUser(@RequestBody Contact contact) {
	contactservice.add(contact);
	return ResponseEntity.status(HttpStatus.OK).body("Contact added succesfully");
	}

	@DeleteMapping("/deletecontact/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable int id) throws  DeleteContactException{
	Contact contact =contactservice.find(id);
	if(contact==null) {
	throw new DeleteContactException(id);
	}
	contactservice.delete(id);
	return ResponseEntity.ok("Contact deleted succesfully");
	}
}
