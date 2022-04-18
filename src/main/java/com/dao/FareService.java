package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightPackage.Fare;

@Service
public class FareService 
{
	@Autowired
	FareDAO FareDAOImpl;
	
	public void add(Fare fare)
	{
		FareDAOImpl.add(fare);
	}
	public boolean modifyFare(Fare fare)
	{
		return FareDAOImpl.modifyFare(fare);
	}
	public boolean delete(int id)
	{
		return FareDAOImpl.deleteFare(id);
	}
	public Fare find(int id)
	{
		return FareDAOImpl.findFare(id);
	}
	public List<Fare> findAll()
	{
		return FareDAOImpl.findAllFare();
	}
}
