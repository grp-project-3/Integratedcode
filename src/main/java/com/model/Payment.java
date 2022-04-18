package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity

public class Payment {
@Id
@GeneratedValue
private int id;
private double amount;

public Payment() {}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public double getAmount() {
	return amount;
}

public void setAmount(double amount) {
	this.amount = amount;
}


}
