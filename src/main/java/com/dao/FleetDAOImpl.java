package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flightPackage.Fleet;

@Component
public class FleetDAOImpl implements FleetDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addFleet(Fleet fleet) 
	{
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(fleet);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Fleet findFleet(int id) 
	{
		Session session = sessionFactory.openSession();
		Fleet fleet = session.get(Fleet.class,id);
		return fleet;
	}

	@Override
	public List<Fleet> findAllFleet() 
	{
		Session session = sessionFactory.openSession();
		List<Fleet> fleetlist = session.createQuery("select f from Fleet f").list(); 
		return fleetlist;
	}

	@Override
	public boolean updateFleet(Fleet fleet) 
	{
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(fleet);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteFleet(int id)
	{
		Session session = sessionFactory.openSession();
		Fleet fleet = session.find(Fleet.class,id);
		session.getTransaction().begin();
		session.delete(fleet);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return false;		
	}
}
