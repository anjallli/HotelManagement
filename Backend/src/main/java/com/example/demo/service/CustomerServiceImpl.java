package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dao.CustomerDao;

import com.example.demo.entity.Customer;

import com.example.demo.entity.Owner;
import com.example.demo.exception.ResourceNotFoundException;
@Service
public class CustomerServiceImpl implements CustomerService
{
@Autowired
CustomerDao dao;
	
	@Override
	public List<Customer> findAllCustomer() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	@Override
	public Customer addCustomer(Customer e) {
		System.out.println("Customer added Succesfully "+e);
		Customer existingProduct=dao.findById(e.getEmployeeId()).orElse(null);
		
		if(existingProduct==null)
		{	
			
			e.setEmployeeName(e.getEmployeeName());
			e.setEmployeeEmailId(e.getEmployeeEmailId());
			e.setEmployeeContactNumber(e.getEmployeeContactNumber());
			e.setEmployeeAddress(e.getEmployeeAddress());

			return dao.save(e);
		}
		else
		{
			throw new ResourceNotFoundException("Customer already exist");
		}
	}
	
	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return this.dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :" + id));

	}
	@Override
	public Customer updateCustomer(Customer e) {
		Customer existingCustomer=dao.findById(e.getEmployeeId()).orElseThrow(() -> new ResourceNotFoundException("Customer not exist with id :"));
		existingCustomer.setEmployeeName(e.getEmployeeName());
		existingCustomer.setEmployeeEmailId(e.getEmployeeEmailId());
		existingCustomer.setEmployeeContactNumber(e.getEmployeeContactNumber());
		existingCustomer.setEmployeeAddress(e.getEmployeeAddress());
		
		return dao.save(existingCustomer);
	}
	@Override
	public String deleteById(int id) {
		Customer existsID=dao.findById(id).orElse(null);
		if(existsID!=null)
		{
		dao.deleteById(id);
		return "Customer deleted!!";
		}
		else
		{
		throw new ResourceNotFoundException("Customer id not available");

		}
	}
	
	
	@Override
	public Customer findByUsername(String uname) {
		// TODO Auto-generated method stub
		return dao.findByUsername(uname) ;
	}
	@Override
	public ResponseEntity<?> saveUser(Customer user) {
		Customer u=dao.findByUsername(user.getUsername());
		if(u!=null) {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();	
		}
		else {
			dao.save(user);
			return ResponseEntity.ok(user);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody Customer userData) {
		Customer user = dao.findByUsername(userData.getUsername());

		if (user.getPassword().equals(userData.getPassword())) {
			Customer senduser=new Customer();
			senduser.setEmployeeId(user.getEmployeeId());
			senduser.setEmployeeName(user.getEmployeeName());
			senduser.setEmployeeAddress(user.getEmployeeAddress());
			senduser.setEmployeeContactNumber(user.getEmployeeContactNumber());
			senduser.setEmployeeEmailId(user.getEmployeeEmailId());
			senduser.setUsername(user.getUsername());

			return ResponseEntity.ok(senduser);
		} else {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
	}

	

	

}
