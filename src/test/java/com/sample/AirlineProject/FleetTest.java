package com.flight.FlightProject;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.FleetService;
import com.flightPackage.Fleet;
import com.flightPackage.Location;

import junit.framework.Assert;

@SpringBootTest
class FleetTest 
{
	@Autowired
	FleetService service;
	
	@Test
	void testAdd() 
	{
		Fleet fleet = new Fleet();
		fleet.setCode("B2A68");
		fleet.setModel("Amber Flare");
		fleet.setTotalBusinessSeats(143);
		fleet.setTotalEconomySeats(360);
		fleet.setTotalPremiumSeats(130);
		service.add(fleet);
		
		Fleet fleet_to_be_tested = service.find(fleet.getId());
		Assert.assertEquals("B2A68",fleet_to_be_tested.getCode());
		Assert.assertEquals("Amber Flare",fleet_to_be_tested.getModel());
		Assert.assertEquals(143,fleet_to_be_tested.getTotalBusinessSeats());
		Assert.assertEquals(360,fleet_to_be_tested.getTotalEconomySeats());
		Assert.assertEquals(130,fleet_to_be_tested.getTotalPremiumSeats());
	}
	
	@Test
	void testFind() 
	{		
		Fleet fleet = new Fleet();
		fleet.setCode("B2A68");
		Fleet fleet1 = service.find(fleet.getId());
		Assert.assertNull(fleet1);
	}

	@Test
	void testFindAll() 
	{
		Fleet fleet = new Fleet();
		fleet.setCode("ABCF2");
		fleet.setModel("Dead Pool Services");
		fleet.setTotalBusinessSeats(473);
		fleet.setTotalEconomySeats(622);
		fleet.setTotalPremiumSeats(930);
		service.add(fleet);
		
		Fleet fleet1 = new Fleet();
		fleet1.setCode("ABCF2");
		fleet1.setModel("Kazakisthan Services");
		fleet1.setTotalBusinessSeats(432);
		fleet1.setTotalEconomySeats(423);
		fleet1.setTotalPremiumSeats(2400);
		service.add(fleet1);
		
		Fleet fleet2 = new Fleet();
		fleet2.setCode("25364C");
		fleet2.setModel("Burj Services");
		fleet2.setTotalBusinessSeats(733);
		fleet2.setTotalEconomySeats(522);
		fleet2.setTotalPremiumSeats(1230);
		service.add(fleet2);
		
		
		List<Fleet> fleetlist = service.findAll();
		fleetlist.get(0).getCode();
		Assert.assertEquals(fleetlist.get(0).getCode(),"6598V");
	}

	@Test
	void testUpdate() 
	{
		Fleet fleet = new Fleet();
		Fleet fleet_to_be_tested = service.find(1);
		fleet_to_be_tested.setCode("3256B");
		fleet_to_be_tested.setModel("Model");
		fleet_to_be_tested.setTotalBusinessSeats(200);
		fleet_to_be_tested.setTotalEconomySeats(500);
		fleet_to_be_tested.setTotalPremiumSeats(240);
		service.update(fleet_to_be_tested);
		
		Fleet fleet_to_be_tested1 = service.find(1);
		
		Assert.assertEquals("3256B",fleet_to_be_tested1.getCode());
		
	}

	@Test
	void testDelete() 
	{		
		Fleet fleet=service.find(2);
		
		Fleet fleet_to_be_tested = service.find(2);
		Assert.assertNull(fleet_to_be_tested);
	}
}
