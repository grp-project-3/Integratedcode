package com.flight.FlightProject;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.AdminService;
import com.flightPackage.Admin;
import com.flightPackage.Fare;
import com.flightPackage.Fleet;
import com.flightPackage.Flight;
import com.flightPackage.FlightStatus;
import com.flightPackage.Location;

import junit.framework.Assert;

@SpringBootTest
public class AdminTest 
{
	@Autowired
	AdminService service;
	
	@Test
	void testAdd() {
		Admin admin=new Admin();
		admin.setUserName("Pavan");
		admin.setPassword("Pavankumar@36");
Flight flight = new Flight();
		
		Fleet fleet = new Fleet();
		fleet.setCode("23654");
		fleet.setModel("Dracula");
		
		Location location = new Location();
		location.setName("Chennai");
		location.setAirportName("Chinna pallasa airport");
		location.setCode("524768");
		location.setCountry("India");
		
		Location location1 = new Location();
		location1.setName("Delhi");
		location1.setAirportName("Dalda chouhan airport");
		location1.setCode("625345");
		location1.setCountry("India");
		
		String str="2022-03-30";
		String str1="2022-04-02";
		Date date = Date.valueOf(str);
		Date date1=Date.valueOf(str1);
		
		long diff = date1.getTime() - date.getTime();
		String diffHrs = diff/ (1000*60*60)+" Hrs";
		flight.setTravelTime(diffHrs);
		
		FlightStatus flightStatus=new FlightStatus();
		flightStatus.setRemainingBusinessSeats(3543);
		flightStatus.setRemainingEconomySeats(5431);
		flightStatus.setRemainingPremiumSeats(5487);
		
		flight.setDepartureLocation(location);
		flight.setDepartureTime(date);
		flight.setArrivalTime(date1);
		flight.setArrivalLocation(location1);
		
		Fare fare = new Fare();
		fare.setBusinessFare(256.0);
		fare.setEconomyFare(3265.125);
		fare.setPremiumFare(8569.25);
		service.add(admin);
		
		
		Admin admin1=service.find(admin.getId());
		Assert.assertEquals("Pavan",admin.getUserName());
	}
	
	@Test
	void testFind() {
		Admin admin=new Admin();
		admin.setUserName("Chari");
		admin.setPassword("CharuCharmish");
		Admin admin1=service.find(admin.getId());
		Assert.assertNull(admin1);
	}
	@Test
	void testFindAll() {
		Admin admin=new Admin();
		admin.setUserName("Malli");
		admin.setPassword("MalliChari");
		service.add(admin);
		
		Admin admin1=new Admin();
		admin.setUserName("Suri");
		admin.setPassword("JayaSri");
		service.add(admin1);
		
		List<Admin> adminlist=service.findAll();
		Assert.assertEquals(adminlist.get(1).getPassword(), "Pavankumar@36");

}
	@Test
	void testUpdate() {
		Admin admin=new Admin();
		admin.setUserName("Rohit Sharma");
		admin.setPassword("HitMan");
		service.add(admin);
		
		service.update(admin);
		Assert.assertEquals(true, service.update(admin));
				
		}
	
	@Test 
	void testDelete() {
		Admin admin= service.find(3);
		service.delete(admin.getId());
		Admin admin1=service.find(3);
		Assert.assertNull(admin1);
	}

}
