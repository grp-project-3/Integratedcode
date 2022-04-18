package com.controller;

public class DeleteBookingException  extends RuntimeException{

		private int id;
		public DeleteBookingException(int id) {
			
			super("id "+id+" not found");
			this.id=id;
		}

		

		@Override
		public String toString() {
			return "id "+ id +" not available";
		}
		
		
		
	}

