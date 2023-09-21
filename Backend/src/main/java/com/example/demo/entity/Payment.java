package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Table(name="payment")
@Entity
public class Payment {
	@Column(name="paymentId")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int paymentId;
	

	
	@NotNull(message = "customer id can not be empty")
	@Column(name="customerId")
	private int customerId;
	
	@Column(name = "totalAmount")
	private double totalAmount;
	
	

	
	@NotNull(message = "cardNumber can not be empty")
	@Size(max = 16,message = "cardNumber can't be more than 16 characters")
	@Size(min=16, message="cardNumber must be more than 16 characters")
	@Column(name = "cardNumber")
	private long cardNumber;
	
	@NotNull(message = "cvv can not be empty")
	@Size(max = 3,message = "cvv can't be more than 3 characters")
	@Size(min=3, message="cvv must be more than 3 characters")
	@Column(name = "cvv")
	private int cvv;
	
	
	@NotNull(message = "cardHolderName can not be empty")
	@Size(max = 20, message = "cardHolderName can't be more than 20 characters")
	@Size(min = 2, message = "cardHolderName must be more than 2 characters")
	@Column(name = "cardHolderName")
	private String cardHolderName;
	
	
	
	@NotBlank(message = "Status can not be empty")
	@Size(max = 1000,message = "Status can't be more than 1000 characters")
	@Size(min=1, message="Status must be more than 10 characters")
	@Column(name="status")
	private String status;
	
	
	
	public Payment() {
		
	}



	public Payment(int paymentId,int customerId, double totalAmount,long cardNumber, int cvv, String cardHolderName,String status) {
		super();
		this.paymentId = paymentId;
		
		this.customerId = customerId;
		this.totalAmount = totalAmount;
		
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.cardHolderName = cardHolderName;
		this.status = status;
	}



	public int getPaymentId() {
		return paymentId;
	}



	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}



	



	public int getCustomerId() {
		return customerId;
	}



	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}



	public double getTotalAmount() {
		return totalAmount;
	}



	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}







	public long getCardNumber() {
		return cardNumber;
	}



	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}



	public int getCvv() {
		return cvv;
	}



	public void setCvv(int cvv) {
		this.cvv = cvv;
	}



	public String getCardHolderName() {
		return cardHolderName;
	}



	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", customerId=" + customerId + ", totalAmount=" + totalAmount
				+ ", cardNumber=" + cardNumber + ", cvv=" + cvv + ", cardHolderName=" + cardHolderName + ", status="
				+ status + "]";
	}



	
		
}

