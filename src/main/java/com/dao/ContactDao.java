package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.Contact;
import com.model.User;


@Repository
public interface ContactDao {
	public void addContact(Contact contact);
	public Contact findContact(int id);
	public List<Contact> findAllContact();
	public boolean deleteContact(int id);
}
