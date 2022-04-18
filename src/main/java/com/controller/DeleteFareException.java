package com.controller;

public class DeleteFareException extends RuntimeException
{
	private int id;
	public DeleteFareException(int id)
	{
		super("FareId "+id+" not found to delete");
		this.id=id;
	}

	@Override
	public String toString() 
	{
		return "FareId "+id+" is not available to delete";
	}
}
