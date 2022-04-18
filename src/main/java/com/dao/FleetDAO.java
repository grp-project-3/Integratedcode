package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.flightPackage.*;

@Repository
public interface FleetDAO 
{
	public void addFleet(Fleet fleet);
	public Fleet findFleet(int id);
	public List<Fleet> findAllFleet();
	public boolean updateFleet(Fleet fleet);
	public boolean deleteFleet(int id);
}
