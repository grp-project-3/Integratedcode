package com.controller;

public class DeletePassengerException extends RuntimeException{

			private int id;
			public DeletePassengerException(int id) {
				
				super("id "+id+" not found");
				this.id=id;
			}

			

			@Override
			public String toString() {
				return "id "+ id +" not available";
			}
			
			
			
		}


	

