package com.sample.OnlineFlightTicket;
import org.junit.Assert;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.dao.PassengerService;
import com.model.Passenger;
@SpringBootTest
class PassengerTest {
	@Autowired
	PassengerService service;
	@Test
	void contextLoads() {
		
	}
	
	
	@Test
	void testAdd() {

		Passenger passenger=new Passenger();
	//	passenger.setId(1);
		passenger.setFirstName("chaitanya");
		passenger.setLastName("Madhura");
		passenger.setAge(20);
        passenger.setPassportNo("2589634");
		passenger.setMealPref("indian food");
		passenger.setGender('f');
        service.add(passenger); 
        
       
	Passenger passenger2=service.find(passenger.getId());
	Assert.assertEquals("chaitanya", passenger.getFirstName());
		
	}
	
	@Test
	void testFind() {
		Passenger passenger=service.find(1);
		Assert.assertNotNull(passenger);
	}
	@Test
	void testFindAll()
	{
		Passenger passengerA=new Passenger();
		passengerA.setId(1);
		passengerA.setFirstName("srividya");
		passengerA.setLastName("Madhura");
		passengerA.setAge(20);
        passengerA.setPassportNo("2589634");
		passengerA.setMealPref("indian food");
		passengerA.setGender('f');
        service.add(passengerA); 
        List<Passenger> passengerlist=service.findAll();
        Assert.assertEquals(passengerlist.get(1).getFirstName(),"srividya");
	}
	

	@Test
	void testUpdate() {
		Passenger psngr=new Passenger();
		psngr.setId(3);
		psngr.setFirstName("sandhya");
		psngr.setLastName("D");
		psngr.setAge(22);
        psngr.setPassportNo("2589636");
		psngr.setMealPref("indian food");
		psngr.setGender('f');
		psngr.setAge(20);
		service.add(psngr);
		
	Passenger psngr1=service.find(psngr.getId());
	Assert.assertEquals(true, service.update (psngr));
		}
	
	
	@Test
	void testDelete() {
	Passenger passenger=service.find(1);
	service.delete(passenger.getId());
	Passenger passenger1=service.find(passenger.getId());
	Assert.assertNull(passenger1);
	
	}
	
}
