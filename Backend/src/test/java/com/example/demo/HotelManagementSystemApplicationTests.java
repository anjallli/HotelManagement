package com.example.demo;

import java.text.ParseException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dao.CustomerDao;

import com.example.demo.dao.OwnerDao;

import com.example.demo.entity.Owner;
import com.example.demo.entity.Customer;

@SpringBootTest
class HotelManagementSystemApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Autowired
	private OwnerDao ownerDao;
	@Test
	public void testCreate() throws ParseException
	{
		
		
		Owner o=new Owner();
	
		o.setOwnerId(10);
		o.setOwnerAddress("Pune");
		o.setOwnerContactNumber("8080101404");
		o.setOwnerEmailId("anjalim1006@gmail.com");
		o.setOwnerName("Anjali");
     
		ownerDao.save(o);

	}
	
	
	@Autowired
	private CustomerDao customerDao;
	@Test
	public void customertestCreate() throws ParseException
	{
		
		
		Customer c=new Customer();
	
		c.setEmployeeId(10);
		c.setEmployeeName("Rutuja");
		c.setEmployeeAddress("Pune");
		c.setEmployeeContactNumber("8080101403");
		c.setEmployeeEmailId("rutuja03kondra@gmail.com");
		
     
		customerDao.save(c);

	}
	
	
	
	
	
	

}
