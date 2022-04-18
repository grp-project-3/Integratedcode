package com.controller;

public class UpdateFlightException extends RuntimeException
{
	
	public UpdateFlightException()
	{
		super("FlightId is not found to update");
	}

	@Override
	public String toString() {
		return "FlightId is not available to update";
	}
}
