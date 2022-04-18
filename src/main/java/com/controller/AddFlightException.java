package com.controller;

public class AddFlightException extends RuntimeException
{
	public AddFlightException()
	{
		super("Flightid cannot be added due to missing details");
	}

	@Override
	public String toString() 
	{
		return "Flight is not added, some data is missing";
	}
}
