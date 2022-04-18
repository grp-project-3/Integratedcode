package com.flight.FlightProject;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.FlightService;
import com.flightPackage.Admin;
import com.flightPackage.Fare;
import com.flightPackage.Fleet;
import com.flightPackage.Flight;
import com.flightPackage.FlightStatus;
import com.flightPackage.Location;

import junit.framework.Assert;

@SpringBootTest
class FlightTest 
{
	@Autowired
	FlightService service;
	
	@Test
	void testAdd() 
	{
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
		
		Admin admin = new Admin();
		admin.setUserName("Pavan");
		admin.setPassword("Kumar");
		
		admin.setFare(fare);
		admin.setFleet(fleet);
		admin.setFlight(flight);
		admin.setFlightStatus(flightStatus);
		admin.setLocation(location);
		flight.setFleet(fleet);
		flight.setAdmin(admin);
		flight.setFare(fare);
		service.add(flight);
		
		Flight flight1=service.find(flight.getId());
		Assert.assertEquals(flight1.getDepartureTime(),date);
	}

	@Test
	void testFind() 
	{
		Flight flight= new Flight();
		String str="2021-02-22";
		Date date=Date.valueOf(str);
		flight.setDepartureTime(date);
		Flight flight1 = service.find(flight.getId());
		Assert.assertNull(flight1);
	}

	@Test
	void testFindAll() 
	{
		Flight flight = new Flight();
		Fleet fleet = new Fleet();
		fleet.setCode("ABVG32");
		fleet.setModel("Monster");
		FlightStatus flightStatus = new FlightStatus();
		
		Location location = new Location();
		location.setName("Austria");
		location.setAirportName("Low lalanga astria airport");
		location.setCode("524768");
		location.setCountry("Austria");
		
		flight.setDepartureLocation(location);
		String str="2023-03-30";
		String str1="2023-04-02";
		Date date = Date.valueOf(str);
		Date date1=Date.valueOf(str1);
		flight.setDepartureTime(date);
		flight.setArrivalTime(date1);
		
		long diff = date1.getTime() - date.getTime();
		String diffHrs = diff/ (1000*60*60)+" Hrs";
		flight.setTravelTime(diffHrs);
		
		Location location1 = new Location();
		location1.setName("Mumbai");
		location1.setAirportName("Chinna pallasa airport");
		location1.setCode("524768");
		location1.setCountry("India");
		
		flight.setArrivalLocation(location1);
		flight.setFleet(fleet);
		flight.setStatus(flightStatus);
		service.add(flight);
		
		Flight flight1 = new Flight();
		Fleet fleet1 = new Fleet();
		fleet1.setCode("6598V");
		fleet1.setModel("Vampire");
		FlightStatus flightStatus1 = new FlightStatus();
		
		Location location2 = new Location();
		location2.setName("Lucknow");
		location2.setAirportName("Dungal dabang airport");
		location2.setCode("587655");
		location2.setCountry("India");
		
		flight1.setDepartureLocation(location2);
		String str2="2021-06-10";
		String str3="2021-06-12";
		Date date2 = Date.valueOf(str2);
		Date date3=Date.valueOf(str3);
		flight1.setDepartureTime(date2);
		flight1.setArrivalTime(date3);
		
		long diff1 = date2.getTime() - date3.getTime();
		String diffHrs1 = diff1/ (1000*60*60)+" Hrs";
		flight.setTravelTime(diffHrs1);
		
		Location location3 = new Location();
		location3.setName("Chennai");
		location3.setAirportName("Chinna pallasa airport");
		location3.setCode("524768");
		location3.setCountry("India");
		
		flight1.setArrivalLocation(location3);
		flight1.setFleet(fleet1);
		flight1.setStatus(flightStatus1);
		service.add(flight1);
		
		Flight flight2 = new Flight();
		Fleet fleet2 = new Fleet();
		fleet2.setCode("354680");
		fleet2.setModel("Captain");
		FlightStatus flightStatus2 = new FlightStatus();
		
		Location location4 = new Location();
		location4.setName("Norway");
		location4.setAirportName("Nortingal airport");
		location4.setCode("524768");
		location4.setCountry("Norway");
		
		flight2.setDepartureLocation(location4);
		String str4="2022-03-11";
		String str5="2022-03-11";
		Date date4 = Date.valueOf(str4);
		Date date5=Date.valueOf(str5);
		flight2.setDepartureTime(date4);
		flight2.setArrivalTime(date5);
		
		long diff2 = date4.getTime() - date5.getTime();
		String diffHrs2 = diff2/ (1000*60*60)+" Hrs";
		flight.setTravelTime(diffHrs2);
		
		Location location5 = new Location();
		location5.setName("Marvel universe");
		location5.setAirportName("Buckinghum airport");
		location5.setCode("524768");
		location5.setCountry("MCU");
		
		flight2.setArrivalLocation(location5);
		flight2.setFleet(fleet2);
		flight2.setStatus(flightStatus2);
		service.add(flight2);
		
		List<Flight> flightlist = service.findAll();
		Assert.assertEquals(flightlist.get(0).getDepartureLocation(),flightlist.get(0).getDepartureLocation());
	}

	@Test
	void testUpdate() 
	{
		Flight flight = new Flight();
		Flight flight1 = service.find(1);
		Fleet fleet = new Fleet();
		fleet.setCode("23465");
		fleet.setModel("Hulk Buster");
		FlightStatus flightStatus = new FlightStatus();
		
		Location location = new Location();
		location.setName("Queens");
		location.setAirportName("DeadSpiderMan airport");
		location.setCode("524768");
		location.setCountry("LosAngles");
		
		flight1.setDepartureLocation(location);
		String str="2023-08-30";
		String str1="2023-09-02";
		Date date = Date.valueOf(str);
		Date date1=Date.valueOf(str1);
		flight1.setDepartureTime(date);
		flight1.setArrivalTime(date1);
		
		long diff = date1.getTime() - date.getTime();
		String diffHrs = diff/ (1000*60*60)+" Hrs";
		flight.setTravelTime(diffHrs);
		
		Location location1 = new Location();
		location1.setName("Srinagar");
		location1.setAirportName("Chinna pallasa airport");
		location1.setCode("524768");
		location1.setCountry("India");
		
		flight1.setArrivalLocation(location1);
		flight1.setFleet(fleet);
		flight1.setStatus(flightStatus);
		
		service.update(flight1);
		
		Flight flight_to_be_tested = service.find(1);
		
		Assert.assertEquals(date,flight_to_be_tested.getDepartureTime());
	}

	@Test
	void testDelete() 
	{
		service.delete(2);
		
		Flight flight_to_be_tested = service.find(2);
		Assert.assertNull(flight_to_be_tested);
	}

}
