package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Booking;
@Component
public class BookingDAOImpl implements BookingDAO {
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public void addBooking(Booking booking) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(booking);
		session.flush();
		session.getTransaction().commit();
		session.close();


	}

	@Override
	public Booking findBooking(int id) {
		Session session=sessionFactory.openSession();
		   Booking booking=session.find(Booking.class, id);
			return booking;
	}

	@Override
	public List<Booking> findAllBooking() {
		Session session=sessionFactory.openSession();
		List<Booking> bookinglist=session.createQuery("select i from booking i").list();
	return bookinglist;
	}

	@Override
	public boolean updateBooking(Booking booking) {
		Session session=sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(booking);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteBooking(int id) {
		Session session=sessionFactory.openSession();
		Booking booking=session.find(Booking.class,id);
		session.getTransaction().begin();
		session.delete(booking);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return false;
	}

}
