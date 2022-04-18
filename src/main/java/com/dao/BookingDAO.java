package com.dao;
import org.springframework.stereotype.Repository;

import com.model.*;

import java.util.*;
@Repository
public interface BookingDAO {
	
		public void addBooking(Booking booking);
		public Booking findBooking(int id);
		public List<Booking> findAllBooking();
		public boolean updateBooking(Booking booking);
		public boolean deleteBooking(int id);

	}

