package com.controller;

public class DeleteLocationException extends RuntimeException
{
	private int id;
	public DeleteLocationException(int id)
	{
		super("LocationId "+id+" not found to delete");
		this.id=id;
	}

	@Override
	public String toString() 
	{
		return "LocationId "+id+" is not available to delete";
	}
}
