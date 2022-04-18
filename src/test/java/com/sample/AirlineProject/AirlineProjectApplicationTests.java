package com.sample.AirlineProject;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dao.UserService;
import com.model.User;

import junit.framework.Assert;

@SpringBootTest
class AirlineProjectApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	UserService service;
			@Test
			void testAdd() {
				User user=new User();
				user.setUserName("Steffi");
				user.setPassword("Peenya 1 stage");
				user.setFirstName("Pragati");
				user.setLastName("Desai");	
				service.add(user);
				User user1=service.find(user.getId());
					Assert.assertEquals("Steffi", user1.getUserName());
				
	}
			@Test
			void testFind() {
				User user2=new User();
				user2.setUserName("Steffi");
				User user3=service.find(user2.getId());
				Assert.assertNull(user3);
			}
			@Test
			void testFindAll() {
				User profile5=new User();
				profile5.setUserName("Ranjitha");
				profile5.setPassword("Laggere");
				profile5.setFirstName("Steffi");
				profile5.setLastName("Bangalore");
				
			
				service.add(profile5);
				User profile6=new User();
				profile6.setUserName("Steffi");
				profile6.setPassword("Belgavi");
				profile6.setFirstName("Ranjan");
				profile6.setLastName("Belgaum");
				

				service.add(profile6);
			List<User>userlist=service.findAll();
			Assert.assertEquals(userlist.get(1).getUserName(), "Ranjitha");
			Assert.assertEquals(userlist.get(1).getLastName(), "Bangalore");

}
			@Test
			void testUpdate() {
				User uc=new User();
				uc.setUserName("Lakshmi");
				uc.setPassword("Lakshmi@gmail.com");
				uc.setFirstName("Radhika");
				uc.setLastName("Pune");
				
		
				service.add(uc);
				
				service.update(uc);
				Assert.assertEquals(true, service.update(uc));
						
				}
			@Test 
			void testDelete() {
				User u1 = service.find(3);
				service.delete(u1.getId());
//				if(u1!=null) {
//					System.out.println("****Not deleted****");
//					
//				}
				User u2=service.find(3);
				Assert.assertNull(u2);
			}
			
			
			
			
			
			
			
			
}