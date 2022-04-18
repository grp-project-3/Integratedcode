package com.controller;

import java.util.Arrays;

public class FindGuestUserException extends RuntimeException {
	private int id;
	public FindGuestUserException(int id) {
		
		super("id "+id+" not found");
		this.id=id;
	}

	@Override
	public String toString() {
		return "id "+ id +" not available";
	}
}
