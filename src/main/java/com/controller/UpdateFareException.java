package com.controller;

public class UpdateFareException extends RuntimeException
{
	public UpdateFareException()
	{
		super("FareId is not found to update");
	}

	@Override
	public String toString() {
		return "FareId is not available to update";
	}
}
