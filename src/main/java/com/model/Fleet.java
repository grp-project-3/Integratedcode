package com.flightPackage;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name="Fleet")
public class Fleet 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String code;
	private String model;
	private int totalEconomySeats;
	private int totalPremiumSeats;
	private int totalBusinessSeats;
	
	@OneToOne
	private Admin admin;
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Fleet() {}

	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getCode() 
	{
		return code;
	}

	public void setCode(String code) 
	{
		this.code = code;
	}

	public String getModel() 
	{
		return model;
	}

	public void setModel(String model) 
	{
		this.model = model;
	}

	public int getTotalEconomySeats() 
	{
		return totalEconomySeats;
	}

	public void setTotalEconomySeats(int totalEconomySeats) 
	{
		this.totalEconomySeats = totalEconomySeats;
	}

	public int getTotalPremiumSeats() 
	{
		return totalPremiumSeats;
	}

	public void setTotalPremiumSeats(int totalPremiumSeats) 
	{
		this.totalPremiumSeats = totalPremiumSeats;
	}

	public int getTotalBusinessSeats() 
	{
		return totalBusinessSeats;
	}

	public void setTotalBusinessSeats(int totalBusinessSeats) 
	{
		this.totalBusinessSeats = totalBusinessSeats;
	}
}
