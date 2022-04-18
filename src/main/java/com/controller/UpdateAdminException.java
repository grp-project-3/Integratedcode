package com.controller;

public class UpdateAdminException extends RuntimeException
{
	public UpdateAdminException()
	{
		super("AdminId is not found to update");
	}

	@Override
	public String toString() {
		return "AdminId is not available to update";
	}
}
