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


import com.example.demo.entity.Payment;

import com.example.demo.service.PaymentService;



@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:4200")

public class PaymentController
{
	@Autowired
	PaymentService service;
	@GetMapping("/list")
	public List<Payment> getAllPayment() 
	{
		return service.findAllPayment();
	}
	@PostMapping("/addPayment")
	public ResponseEntity<Payment> addPayment(@Valid @RequestBody Payment e) {

		return new ResponseEntity<Payment>(service.addPayment(e), HttpStatus.CREATED);
	}
	@GetMapping("findPayment/{PaymentId}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("PaymentId") int PaymentId) {
		return new ResponseEntity<Payment>(service.getPaymentById(PaymentId), HttpStatus.OK);
	
		
	}
	
	@PutMapping("updatePayment")
	public ResponseEntity<Payment> updatePayment(@Valid  @RequestBody Payment e) {
		return new ResponseEntity<Payment>(service.updatePayment(e),HttpStatus.OK);
	}
	
	@DeleteMapping("deletePayment/{PaymentId}")
	public ResponseEntity<Boolean> deleteManager(@PathVariable("PaymentId") int PaymentId) {
		service.deleteById(PaymentId);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
	
	
	

}
