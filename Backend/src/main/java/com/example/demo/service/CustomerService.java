package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Customer;







public interface CustomerService 
{
	public List<Customer>findAllCustomer();
	public Customer addCustomer(Customer e);
	public Customer getCustomerById(int id);
	public Customer updateCustomer(Customer e);
	public String deleteById(int id);
	
	public Customer findByUsername(String uname);
	public ResponseEntity<?> saveUser(@RequestBody Customer user) ;
	
}
