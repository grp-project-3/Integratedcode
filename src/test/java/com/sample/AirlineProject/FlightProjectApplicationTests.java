package com.flight.FlightProject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.dao.FleetService;
import com.flightPackage.Fleet;

import junit.framework.Assert;

@SpringBootTest
public class FlightProjectApplicationTests 
{
	@Test
	void contextLoads() 
	{
	}
}
