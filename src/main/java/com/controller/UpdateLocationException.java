package com.controller;

public class UpdateLocationException extends RuntimeException
{
	public UpdateLocationException()
	{
		super("LocationId is not found to update");
	}

	@Override
	public String toString() {
		return "LocationId is not available to update";
	}
}
