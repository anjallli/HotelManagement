package com.example.demo.entity;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Table(name ="BookMaster")
@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookid")
	private int bookId;

	
	//@NotNull(message = "roomno cannot be null")
	//@Size(min=1,message="room number must be more than 0")
	@Column(name = "roomno")
	private int roomNo;

	
	@Column(name="noofDays")
	private int noOfDays;
	@Column(name = "roomType")
	private String roomType;
	@Column(name = "totalAmount")
	private double totalAmount;
	
	
	
	//@NotNull(message = "book_id can not be null")
	@Column(name="customer_id")
	private int customerId;
    
	@ManyToOne(targetEntity=Booking.class,fetch=FetchType.EAGER)
	@JoinColumn(name="customer_id",insertable=false,updatable=false)
	private Booking book;
	
	
	
	public Booking() {

	}

	public Booking(int bookId,
			@NotNull(message = "roomno cannot be null") @Size(min = 1, message = "room number must be more than 0") int roomNo,
			int noOfDays, String roomType, double totalAmount,int customerId) {
		super();
		this.bookId = bookId;
		this.roomNo = roomNo;
		this.noOfDays = noOfDays;
		this.roomType = roomType;
		this.totalAmount = totalAmount;
		this.customerId=customerId;
		
	}
	

	


	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getRoomNo() {
		return roomNo;
	}

	

	

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(int noOfDays) {
		this.noOfDays = noOfDays;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Booking [bookId=" + bookId + ", roomNo=" + roomNo + ", noOfDays=" + noOfDays + ", roomType=" + roomType
				+ ", totalAmount=" + totalAmount + ", customerId=" + customerId + "]";
	}


	

	
	
	
	
	
}