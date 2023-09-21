package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Table(name="owner")
@Entity
public class Owner {
	@Column(name="onwerId")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ownerId;
	
	@NotBlank(message = "Owner name can not be empty")
	@Size(max = 20,message = "Owner name can't be more than 20 characters")
	@Size(min=2, message="Owner name must be more than 2 characters")
	@Column(name="ownerName")
	private String ownerName;
	
	@NotBlank(message = "Owner Email Id can not be empty")
	@Size(max = 25,message = "Owner Email Id can't be more than 25 characters")
	@Size(min=11, message="Owner Email Id must be more than 11 characters")
	@Column(name="ownerEmailId")
	private String ownerEmailId;
	
	@NotBlank(message = "Owner contact number can not be empty")
	@Size(max = 10,message = "Owner contact number can't be more than 10 characters")
	@Size(min=10, message="Owner contact number must be more than 10 characters")
	@Column(name="ownerContactNumber")
	private String ownerContactNumber;
	
	@NotBlank(message = "Owner Address can not be empty")
	@Size(max = 100,message = "Owner Address  can't be more than 100 characters")
	@Size(min=1, message="Owner Address  must be more than 50 characters")
	@Column(name="ownerAddress")
	private String ownerAddress;
	
	@Column(name="owner_username")
	private String username;
	
	@Column(name="owner_password")
	private String password;

	public Owner() {
		
	}
	
	public Owner(int ownerId,String ownerName,String ownerEmailId, String ownerContactNumber,String ownerAddress,String username, String password) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.ownerEmailId = ownerEmailId;
		this.ownerContactNumber = ownerContactNumber;
		this.ownerAddress = ownerAddress;
		this.username = username;
		this.password = password;
	}




	

	

	public int getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getOwnerEmailId() {
		return ownerEmailId;
	}

	public void setOwnerEmailId(String ownerEmailId) {
		this.ownerEmailId = ownerEmailId;
	}

	public String getOwnerContactNumber() {
		return ownerContactNumber;
	}

	public void setOwnerContactNumber(String ownerContactNumber) {
		this.ownerContactNumber = ownerContactNumber;
	}

	public String getOwnerAddress() {
		return ownerAddress;
	}

	public void setOwnerAddress(String ownerAddress) {
		this.ownerAddress = ownerAddress;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Owner [ownerId=" + ownerId + ", ownerName=" + ownerName + ", ownerEmailId=" + ownerEmailId
				+ ", ownerContactNumber=" + ownerContactNumber + ", ownerAddress=" + ownerAddress + ", username="
				+ username + ", password=" + password + "]";
	}



	
}
