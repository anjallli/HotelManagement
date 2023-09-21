package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookingDao;
import com.example.demo.entity.Booking;
import com.example.demo.entity.Owner;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingDao dao;

	@Override
	public List<Booking> findAllBooking() {
		return dao.findAll();
	}

	@Override
	public Booking addBooking(Booking e) {
		System.out.println("Booking Succesfully " + e);
		Booking existingBooking = dao.findById(e.getBookId()).orElse(null);

		if (existingBooking == null) {

			e.setBookId(e.getBookId());
			e.setRoomNo(e.getRoomNo());
			e.setNoOfDays(e.getNoOfDays());
			e.setRoomType(e.getRoomType());
			e.setTotalAmount(e.getTotalAmount());
		
			e.setCustomerId(e.getCustomerId());
			
			return dao.save(e);
		} else {
			throw new ResourceNotFoundException("Booking is already Done");
		}
	}

	@Override
	public Booking getBookingById(int id) {
		return this.dao.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Booking not exist with id :" + id));

	}

	@Override
	public Booking updateBooking(Booking e) {
		Booking existingBooking = dao.findById(e.getBookId())
				.orElseThrow(() -> new ResourceNotFoundException("Booking not exist with id :"));

		existingBooking.setBookId(e.getBookId());
		existingBooking.setRoomNo(e.getRoomNo());
		existingBooking.setNoOfDays(e.getNoOfDays());
		existingBooking.setRoomType(e.getRoomType());
		existingBooking.setTotalAmount(e.getTotalAmount());
		
		return dao.save(existingBooking);
	}

	@Override
	public String deleteById(int id) {
		Booking existsID=dao.findById(id).orElse(null);
		if(existsID!=null)
		{
		dao.deleteById(id);
		return "Booking cancelled!!";
		}
		else
		{
		throw new ResourceNotFoundException("Booking id not available");

		}
	}

}