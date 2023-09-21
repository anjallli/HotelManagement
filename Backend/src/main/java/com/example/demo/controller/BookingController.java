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

import com.example.demo.entity.Booking;
import com.example.demo.service.BookingService;



@RestController
@RequestMapping("/booking")
@CrossOrigin(origins = "http://localhost:4200")

public class BookingController
{
	@Autowired
	BookingService service;
	@GetMapping("/list")
	public List<Booking> getAllBooking() 
	{
		return service.findAllBooking();
	}
	@PostMapping("/addbooking")
	public ResponseEntity<Booking> addBooking(@Valid @RequestBody Booking e) {

		return new ResponseEntity<Booking>(service.addBooking(e), HttpStatus.CREATED);
	}
	@GetMapping("find/{bookingid}")
	public ResponseEntity<Booking> getBookingById(@PathVariable("bookingid") int bookingid) {
		return new ResponseEntity<Booking>(service.getBookingById(bookingid), HttpStatus.OK);
	
		
	}
	
	@PutMapping("update")
	public ResponseEntity<Booking> updateBooking(@Valid  @RequestBody Booking e) {
		return new ResponseEntity<Booking>(service.updateBooking(e),HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{bookingid}")
	public ResponseEntity<Boolean> deleteBooking(@PathVariable("bookingid") int bookingid) {
		service.deleteById(bookingid);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
	
	
	

}