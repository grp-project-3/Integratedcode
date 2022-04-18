package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Passenger;

import java.util.List;
import java.util.List.*;

@Component
public class PassengerDAOImpl implements PassengerDAO {

	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void addPassenger(Passenger passenger) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(passenger);
		session.flush();
		session.getTransaction().commit();
		session.close();

	}

	@Override
	public Passenger findPassenger(int id) {
		Session session=sessionFactory.openSession();
	   Passenger passenger=session.find(Passenger.class, id);
		return passenger;
	}
	
	
	@Override
	public boolean updatePassenger(Passenger passenger) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(passenger);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	
	}

	@Override
	public boolean deletePassenger(int id) {
		Session session=sessionFactory.openSession();
		Passenger passenger=session.find(Passenger.class, id);
		session.getTransaction().begin();
		session.delete(passenger);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return false;
	}

	@Override
	public List findAllPassenger() {
		Session session=sessionFactory.openSession();
		List<Passenger> passengerlist=session.createQuery("select i from Passenger i" ).list();
		return passengerlist;
	}
	
	
	
}
	

