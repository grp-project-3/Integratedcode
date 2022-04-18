package com.dao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.model.Contact;
import com.model.User;

@Service
public class ContactService {
	@Autowired
	
	ContactDao contactDAOImpl;
	
	public void add(Contact contact)
	{
		contactDAOImpl.addContact(contact);
	}
	public boolean delete(int id)
	{
		return contactDAOImpl.deleteContact(id);
	}
	public Contact find(int id)
	{
		return contactDAOImpl.findContact(id);
	}
	public List<Contact> findAll()
	{
		return contactDAOImpl.findAllContact();
	}
	
	
}
