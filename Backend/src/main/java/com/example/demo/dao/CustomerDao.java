package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Customer;




@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer>
{
	public Customer findByUsername(String customer_username);
}
