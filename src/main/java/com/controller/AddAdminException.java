package com.controller;

public class AddAdminException extends RuntimeException
{
	public AddAdminException()
	{
		super("Adminid cannot be added due to missing details");
	}

	@Override
	public String toString() 
	{
		return "Admin is not added, some data is missing";
	}
}
