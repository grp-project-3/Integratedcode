package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightPackage.Flight;

@Service
public class FlightService 
{
	@Autowired
	FlightDAO flightDAOImpl;
	
	public void add(Flight flight)
	{
		flightDAOImpl.addFlight(flight);
	}
	
	public Flight find(int id)
	{
		return flightDAOImpl.findFlight(id);
	}
	
	public List<Flight> findAll()
	{
		return flightDAOImpl.findAllFlight();
	}
	
	public boolean update(Flight flight)
	{
		return flightDAOImpl.updateFlight(flight);
	}
	
	public boolean delete(int id)
	{
		return flightDAOImpl.deleteFlight(id);
	}
}
