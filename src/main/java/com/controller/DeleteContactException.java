package com.controller;

public class DeleteContactException extends RuntimeException {

	private int id;
	public DeleteContactException(int id) {
		
		super("id "+id+" not found");
		this.id=id;
	}

	@Override
	public String toString() {
		return "id "+ id +" not available";
	}
}
