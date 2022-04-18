package com.dao;
import java.util.List;

import org.springframework.stereotype.Service;

import com.model.Booking;
import com.model.Passenger;

import org.springframework.beans.factory.annotation.Autowired;


@Service
public class BookingService {

		@Autowired
		BookingDAO bookingDAOImpl;

		public void add(Booking booking)
		{
			bookingDAOImpl.addBooking(booking);
		}
		
		public Booking find(int id)
		{
			return bookingDAOImpl.findBooking(id);
		}
		public List<Booking> findAllBooking()
		{
			return bookingDAOImpl.findAllBooking();

			}

		public boolean update(Booking booking)
		{
			return bookingDAOImpl.updateBooking(booking);
		}
		public boolean delete(int id)
		{
			return bookingDAOImpl.deleteBooking(id);
		}

}
