package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.flightPackage.Fare;

@Repository
public interface FareDAO 
{
	public void add(Fare fare);
	public Fare findFare(int id);
	public List<Fare> findAllFare();
	public boolean modifyFare(Fare fare);
	public boolean deleteFare(int id);
}
