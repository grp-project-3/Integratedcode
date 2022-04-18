package com.jagadesh.FlightTicket;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.dao.*;
import com.model.*;

import junit.framework.Assert;
@SpringBootTest
class FlightStatusTest {
	
	@Autowired
	FlightStatusService service;
	
	@Test
	void contextLoads() {
	
	}
	
	@Test
	void testAdd() {
		
		FlightStatus status=new FlightStatus();
		status.setRemainingBusinessSeats(12);
		status.setRemainingEconomySeats(11);
		status.setRemainingPremiumSeats(10);
		service.add(status);
		FlightStatus status1=service.find(status.getId());
		
	  Assert.assertEquals(12,status1.getRemainingBusinessSeats());
	  Assert.assertEquals(11,status1.getRemainingEconomySeats());
		
	}

	@Test
	void testUpdate() {
		
		FlightStatus status=new FlightStatus();
		status.setRemainingBusinessSeats(17);
		status.setRemainingEconomySeats(5);
		status.setRemainingPremiumSeats(3);
		service.add(status);
		status.setRemainingBusinessSeats(10);
		service.update(status);
		Assert.assertEquals(true, service.update(status));
		
	}

	@Test
	void testDelete() {
		FlightStatus status=new FlightStatus();
		status.setRemainingBusinessSeats(17);
		status.setRemainingEconomySeats(5);
		status.setRemainingPremiumSeats(3);
		service.add(status);
		service.delete(6);
//		FlightStatus status1=service.find(1);
		Assert.assertNull(service.find(6));
		
	}

	@Test
	void testFind() {
		
		FlightStatus status=new FlightStatus();
		status.setRemainingBusinessSeats(12);
		service.add(status);
		FlightStatus status1=service.find(status.getId());
		Assert.assertEquals(12, status1.getRemainingBusinessSeats());
	} 

	@Test
	void testFindAll() {
		FlightStatus status=new FlightStatus();
		status.setRemainingBusinessSeats(11);
		status.setRemainingEconomySeats(11);
		status.setRemainingPremiumSeats(9);
		service.add(status);
		FlightStatus status1=new FlightStatus();
		status1.setRemainingBusinessSeats(6);
		status1.setRemainingEconomySeats(9);
		status1.setRemainingPremiumSeats(10);
		service.add(status1);
		FlightStatus status2=new FlightStatus();
		status2.setRemainingBusinessSeats(5);
		status2.setRemainingEconomySeats(2);
		status2.setRemainingPremiumSeats(1);
		service.add(status2);
		List<FlightStatus> list=service.findAll();
		list.get(0).getRemainingBusinessSeats();
		Assert.assertEquals(list.get(0).getRemainingBusinessSeats(), 12);
	}

}
