package com.controller;

public class FindAdminException extends RuntimeException
{
	private int id;
	public FindAdminException(int id)
	{
		super("AdminId "+id+" not found");
		this.id=id;
	}

	@Override
	public String toString() 
	{
		return "AdminId "+id+" is not available";
	}
}
