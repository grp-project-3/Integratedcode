package com.controller;

public class AddGuestUserException extends RuntimeException {
	private int id;
	public AddGuestUserException(int id) {
		
		super("id "+id+" not found");
		this.id=id;
	}

	@Override
	public String toString() {
		return "id "+ id +" not available";
	}
}

