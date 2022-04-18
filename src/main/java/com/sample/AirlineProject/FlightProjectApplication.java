package com.flight.FlightProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages= {"com.controller","com.flightPackage","com.dao"})
@EntityScan("com.flightPackage")
@EnableJpaRepositories("com.dao")
public class FlightProjectApplication 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(FlightProjectApplication.class, args);
	}
}
