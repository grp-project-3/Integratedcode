package com.dao;

import org.springframework.stereotype.Repository;

import com.model.Passenger;

import java.util.List;

@Repository
public interface PassengerDAO {

		public void addPassenger(Passenger passenger);
		public Passenger findPassenger(int id);
		public List<Passenger> findAllPassenger();
		public boolean updatePassenger(Passenger passenger);
		public boolean deletePassenger(int id);

	}
	

