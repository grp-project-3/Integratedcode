package com.dao;

import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Contact;
import com.model.User;

@Component
public class ContactDAOImpl implements ContactDao {
	
		@Autowired
		SessionFactory sessionFactory;

		@Override
		public void addContact(Contact contact) {
			// TODO Auto-generated method stub
			Session session=sessionFactory.openSession();
			session.getTransaction().begin();
			session.save(contact);
			session.flush();
			session.getTransaction().commit();
			session.close();
		}
		
		@Override
		public Contact findContact(int id) {
			Session session=sessionFactory.openSession();
		Contact contact=session.find(Contact.class, id);
			// TODO Auto-generated method stub
			return contact;
		}
		@Override
		public List<Contact> findAllContact() {
			Session session=sessionFactory.openSession();
			List<Contact> contactlist=session.createQuery("select i from Contact i").list();
					
			// TODO Auto-generated method stub
			return contactlist;
		}
		@Override
		public boolean deleteContact(int id) {
			Session session=sessionFactory.openSession();
			Contact contact=session.find(Contact.class, id);
			session.getTransaction().begin();
			session.delete(contact);
			session.flush();
			session.getTransaction().commit();
			session.close();
			return false;
			
		}
		


}

