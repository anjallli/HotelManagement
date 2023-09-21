package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Booking;


@Repository 
public interface BookingDao extends JpaRepository<Booking, Integer> {
	
}