package com.controller;

public class UpdateUserException  extends RuntimeException {
	public UpdateUserException() {
		super("User not updated successfully");	
		}

		@Override
		public String toString() {
			return "User updated succesfully";
		}


}
