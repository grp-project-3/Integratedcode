package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.model.FlightStatus;

@Repository
public interface FlightStatusDAO {

	public void addFlightStatus(FlightStatus status);
	public FlightStatus findFlightStatus(int id);
	public List<FlightStatus> findAllFlightStatus();
	public boolean updateFlightStatus(FlightStatus status);
	public boolean deleteFlightStatus(int id);
}
