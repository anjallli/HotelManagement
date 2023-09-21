package com.example.demo.service;

import java.util.List;


import com.example.demo.entity.Payment;





public interface PaymentService 
{
	public List<Payment>findAllPayment();
	public Payment addPayment(Payment e);
	public Payment getPaymentById(int id);
	public Payment updatePayment(Payment e);
	public String deleteById(int id);
}
