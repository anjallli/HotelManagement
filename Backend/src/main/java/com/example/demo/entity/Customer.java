package com.example.demo.entity;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name = "Employee_Master")
public class Customer {
	@Column(name = "employeeId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;

	@NotBlank(message = "Employee name can not be empty")
	@Size(max = 20, message = "Employee name can't be more than 20 characters")
	@Size(min = 2, message = "Employee name must be more than 2 characters")
	@Column(name = "employeeName")
    private String employeeName;

	@NotBlank(message = "Employee Email Id can not be empty")
	@Size(max = 25,message = "Employee Email Id can't be more than 25 characters")
	@Size(min=11, message="Employee Email Id must be more than 11 characters")
	@Column(name="employeeEmailId")
	private String employeeEmailId;

    @NotBlank(message = "Employee contact number can not be empty")
	@Size(max = 10,message = "Employee contact number can't be more than 10 characters")
	@Size(min=10, message="Employee contact number must be more than 10 characters")
	@Column(name="employeeContactNumber")
    private String employeeContactNumber;

    @NotBlank(message = "Employee Address can not be empty")
	@Size(max = 100,message = "Employee Address  can't be more than 100 characters")
	@Size(min=1, message="Employee Address  must be more than 50 characters")
	@Column(name="employeeAddress")
	private String employeeAddress;
	
    @Column(name="customerUsername")
    private String username;
    
    @Column(name="customerpassword")
    private String password;
    
    @OneToMany(mappedBy="book")
	private Set<Booking>booking;
	
    
	public Customer() {
	
	}


	public Customer(int employeeId, String employeeName, String employeeEmailId, String employeeContactNumber,
			String employeeAddress,String username,String password) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmailId = employeeEmailId;
		this.employeeContactNumber = employeeContactNumber;
		this.employeeAddress = employeeAddress;
		this.username=username;
		this.password=password;
		
	}


	

	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public String getEmployeeName() {
		return employeeName;
	}


	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}


	public String getEmployeeEmailId() {
		return employeeEmailId;
	}


	public void setEmployeeEmailId(String employeeEmailId) {
		this.employeeEmailId = employeeEmailId;
	}


	public String getEmployeeContactNumber() {
		return employeeContactNumber;
	}


	public void setEmployeeContactNumber(String employeeContactNumber) {
		this.employeeContactNumber = employeeContactNumber;
	}


	public String getEmployeeAddress() {
		return employeeAddress;
	}


	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
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
		return "Customer [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeEmailId="
				+ employeeEmailId + ", employeeContactNumber=" + employeeContactNumber + ", employeeAddress="
				+ employeeAddress + ", username=" + username + ", password=" + password + ", booking=" + booking + "]";
	}


	

	
	

}