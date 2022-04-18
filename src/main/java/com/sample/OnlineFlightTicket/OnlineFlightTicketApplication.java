package com.sample.OnlineFlightTicket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages= {"com.controller","com.pack1","com.Dao"})
@EntityScan("com.pack1")
@EnableJpaRepositories({"com.Dao"})
public class OnlineFlightTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineFlightTicketApplication.class, args);
	}

}
