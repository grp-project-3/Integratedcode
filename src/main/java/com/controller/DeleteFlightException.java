package com.controller;

import java.util.Arrays;

public class DeleteFlightException extends RuntimeException 
{
	private int id;
	public DeleteFlightException(int id)
	{
		super("FlightId "+id+" not found to delete");
		this.id=id;
	}

	@Override
	public String toString() 
	{
		return "FlightId "+id+" is not available to delete";
	}
}
