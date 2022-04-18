package com.controller;

public class FindFlightException extends RuntimeException
{
	private int id;
	public FindFlightException(int id)
	{
		super("FlightId "+id+" not found");
		this.id=id;
	}

	@Override
	public String toString() 
	{
		return "FlightId "+id+" is not available";
	}
}
