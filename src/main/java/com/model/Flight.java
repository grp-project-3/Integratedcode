package com.flightPackage;

import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Flight 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Location departureLocation;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Location arrivalLocation;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fleet_id")
	private Fleet fleet;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="flightStatus_id")
	private FlightStatus status;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="location_id")
	private Location location;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="fare_id")
	private Fare fare;	
	
	private Date departureTime;
	private Date arrivalTime;
	
	private String travelTime;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="admin_id")
	private Admin admin;
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public Flight(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Location getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(Location departureLocation) {
		this.departureLocation = departureLocation;
	}

	public Location getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(Location arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public Fleet getFleet() {
		return fleet;
	}

	public void setFleet(Fleet fleet) {
		this.fleet = fleet;
	}

	public FlightStatus getStatus() {
		return status;
	}

	public void setStatus(FlightStatus status) {
		this.status = status;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Fare getFare() {
		return fare;
	}

	public void setFare(Fare fare) {
		this.fare = fare;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}
}
