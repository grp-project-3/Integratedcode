package com.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.flightPackage.Fare;

@Component
public class FareDAOImpl implements FareDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void add(Fare fare) 
	{
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(fare);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	@Override
	public boolean modifyFare(Fare fare) {
			
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(fare);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		return true;
		
	}
	@Override
	public Fare findFare(int id) {
		Session session=sessionFactory.openSession();
		Fare status=session.find(Fare.class, id);
		return status;
	}
	@Override
	public List<Fare> findAllFare() {
		Session session=sessionFactory.openSession();
		List<Fare> status=session.createQuery("select i from Fare i").list();
				
		return status;
	}
	@Override
	public boolean deleteFare(int id) {
		
		Session session=sessionFactory.openSession();
		Fare status=session.find(Fare.class, id);
		session.getTransaction().begin();
		session.delete(status);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		return false;
	}
}
