package com.controller;

public class UpdateFleetException extends RuntimeException
{
	public UpdateFleetException()
	{
		super("FleetId is not found to update");
	}

	@Override
	public String toString() {
		return "FleetId is not available to update";
	}
}
