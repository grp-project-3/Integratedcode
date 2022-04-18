package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flightPackage.Location;

@Component
public class LocationDAOImpl implements LocationDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addLocation(Location location) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(location);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	  @Override
      public boolean updateLocation(Location location) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(location);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		return true;
	}
	
	@Override
	public boolean deleteLocation(int Id) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Location location=session.find(Location.class, Id);
		session.getTransaction().begin();
		session.delete(location);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}
	
	@Override
	public Location findLocation(int id) {
		Session session=sessionFactory.openSession();
		Location location=session.find(Location.class, id);
		// TODO Auto-generated method stub
		return location;
	}
	@Override
	public List<Location> findAllLocation() {
		Session session=sessionFactory.openSession();
		List<Location> locationlist=session.createQuery("select i from Location i").list();
				
		// TODO Auto-generated method stub
		return locationlist;
	}

}
