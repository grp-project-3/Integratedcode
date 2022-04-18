package com.controller;

public class DeleteAdminException extends RuntimeException
{
	private int id;
	public DeleteAdminException(int id)
	{
		super("AdminId "+id+" not found to delete");
		this.id=id;
	}

	@Override
	public String toString() 
	{
		return "AdminId "+id+" is not available to delete";
	}
}
