package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Booking;



public interface BookingService {
	public List<Booking>findAllBooking();
	public Booking addBooking(Booking e);
	public Booking getBookingById(int id);
	public Booking updateBooking(Booking e);
	public String deleteById(int id);


}
