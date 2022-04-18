package com.controller;

public class DeleteFleetException extends RuntimeException
{
	private int id;
	public DeleteFleetException(int id)
	{
		super("FleetId "+id+" not found to delete");
		this.id=id;
	}

	@Override
	public String toString() 
	{
		return "FleetId "+id+" is not available to delete";
	}
}
