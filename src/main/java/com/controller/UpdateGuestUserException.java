package com.controller;

import java.util.Arrays;

public class UpdateGuestUserException extends RuntimeException{
	private int id;
	public UpdateGuestUserException(int id) {
		
		super("id "+id+" not found");
		this.id=id;
	}

	@Override
	public String toString() {
		return "id "+ id +" not available";
	}
}
