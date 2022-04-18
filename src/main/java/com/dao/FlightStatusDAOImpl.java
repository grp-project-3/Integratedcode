package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.FlightStatus;

@Component
public class FlightStatusDAOImpl implements FlightStatusDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void addFlightStatus(FlightStatus status) {
			
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(status);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
	}
	@Override
	public boolean updateFlightStatus(FlightStatus status) {
		
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(status);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		return true;
	}
	@Override
	public boolean deleteFlightStatus(int id) {
		
		Session session=sessionFactory.openSession();
		FlightStatus status=session.find(FlightStatus.class, id);
		session.getTransaction().begin();
		session.delete(status);
		session.flush();
		session.getTransaction().commit();
		session.close();
		
		return false;
	}
	@Override
	public FlightStatus findFlightStatus(int id) {
		Session session=sessionFactory.openSession();
		FlightStatus status=session.find(FlightStatus.class, id);
		// TODO Auto-generated method stub
		return status;
	}
	@Override
	public List<FlightStatus> findAllFlightStatus() {
		Session session=sessionFactory.openSession();
		List<FlightStatus> status=session.createQuery("select i from FlightStatus i").list();
				
		// TODO Auto-generated method stub
		return status;
	}

}
