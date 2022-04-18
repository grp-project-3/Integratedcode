package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.flightPackage.Flight;

@Component
public class FlightDAOImpl implements FlightDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addFlight(Flight flight) 
	{
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(flight);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Flight findFlight(int id) 
	{
		Session session = sessionFactory.openSession();
		Flight flight = session.get(Flight.class,id);
		return flight;
	}

	@Override
	public List<Flight> findAllFlight() 
	{
		Session session = sessionFactory.openSession();
		List<Flight> flightlist = session.createQuery("select f from Flight f").list();
		return flightlist;
	}

	@Override
	public boolean updateFlight(Flight flight) 
	{
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(flight);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteFlight(int id) 
	{
		Session session = sessionFactory.openSession();
		Flight flight=session.find(Flight.class,id);
		session.getTransaction().begin();
		session.delete(flight);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return false;
	}
}
