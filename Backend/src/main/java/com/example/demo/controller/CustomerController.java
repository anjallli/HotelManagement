package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.CustomerDao;
import com.example.demo.entity.Customer;

import com.example.demo.entity.Owner;
import com.example.demo.service.CustomerService;




@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")

public class CustomerController
{
	@Autowired
	CustomerService service;
	
	@Autowired
	private CustomerDao dao1;
	
	
	@GetMapping("/list")
	public List<Customer> getAllCustomer() 
	{
		return service.findAllCustomer();
	}

	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody Customer userData) {
		Customer user = dao1.findByUsername(userData.getUsername());

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
	
	@PostMapping("/saveuser")
	public ResponseEntity<?> saveUser(@RequestBody Customer user) {
		Customer u=dao1.findByUsername(user.getUsername());
		if(u!=null) {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();	
		}
		else {
			dao1.save(user);
			return ResponseEntity.ok(user);
		}
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer e) {

		return new ResponseEntity<Customer>(service.addCustomer(e), HttpStatus.CREATED);
	}
	@GetMapping("findCustomer/{CustomerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("CustomerId") int CustomerId) {
		return new ResponseEntity<Customer>(service.getCustomerById(CustomerId), HttpStatus.OK);
	
		
	}
	
	@PutMapping("updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@Valid  @RequestBody Customer e) {
		return new ResponseEntity<Customer>(service.updateCustomer(e),HttpStatus.OK);
	}
	
	@DeleteMapping("deleteCustomer/{CustomerId}")
	public ResponseEntity<Boolean> deleteCustomer(@PathVariable("CustomerId") int CustomerId) {
		service.deleteById(CustomerId);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
	
	
	

}

