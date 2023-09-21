package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.dao.PaymentDao;

import com.example.demo.entity.Payment;
import com.example.demo.exception.ResourceNotFoundException;
@Service
public class PaymentServiceImpl implements PaymentService
{
@Autowired
PaymentDao dao;
	
	@Override
	public List<Payment> findAllPayment() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	@Override
	public Payment addPayment(Payment e) {
		System.out.println("Payment added Succesfully "+e);
		Payment existingProduct=dao.findById(e.getPaymentId()).orElse(null);
		
		if(existingProduct==null)
		{	
			
			
			e.setStatus(e.getStatus());
			e.setCustomerId(e.getCustomerId());
			e.setPaymentId(e.getPaymentId());
			e.setTotalAmount(e.getTotalAmount());
			e.setCardHolderName(e.getCardHolderName());
			e.setCardNumber(e.getCardNumber());
			e.setCvv(e.getCvv());
			
			
			return dao.save(e);
		}
		else
		{
			throw new ResourceNotFoundException("Payment already exist");
		}
	}
	
	@Override
	public Payment getPaymentById(int id) {
		// TODO Auto-generated method stub
		return this.dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Payment not exist with id :" + id));

	}
	@Override
	public Payment updatePayment(Payment e) {
		Payment existingPayment=dao.findById(e.getPaymentId()).orElseThrow(() -> new ResourceNotFoundException("Payment not exist with id :"));
		
		
		existingPayment.setStatus(e.getStatus());
		existingPayment.setCustomerId(e.getCustomerId());
		existingPayment.setPaymentId(e.getPaymentId());
		existingPayment.setTotalAmount(e.getTotalAmount());
		existingPayment.setCardHolderName(e.getCardHolderName());
		existingPayment.setCardNumber(e.getCardNumber());
		existingPayment.setCvv(e.getCvv());
		
		return dao.save(existingPayment);
	}
	@Override
	public String deleteById(int id) {
		Payment existsID=dao.findById(id).orElse(null);
		if(existsID!=null)
		{
		dao.deleteById(id);
		return "Payment deleted!!";
		}
		else
		{
		throw new ResourceNotFoundException("Payment id not available");

		}
	}
	

}
