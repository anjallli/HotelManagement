package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.OwnerDao;

import com.example.demo.entity.Owner;

import com.example.demo.service.OwnerService;


@RestController
@RequestMapping("/owner")
@CrossOrigin(origins = "http://localhost:4200")

public class OwnerController
{
	@Autowired
	private OwnerService service;
	
	@Autowired
	private OwnerDao dao2;
	
	@GetMapping("/list")
	public List<Owner> getAllOwner() 
	{
		return service.findAllOwner();
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody Owner userData) {
		Owner user = dao2.findByUsername(userData.getUsername());

		if (user.getPassword().equals(userData.getPassword())) {
			Owner senduser=new Owner();
			senduser.setOwnerId(user.getOwnerId());
			senduser.setOwnerName(user.getOwnerName());
			senduser.setOwnerAddress(user.getOwnerAddress());
			senduser.setOwnerContactNumber(user.getOwnerContactNumber());
			senduser.setOwnerEmailId(user.getOwnerEmailId());
			senduser.setUsername(user.getUsername());

			return ResponseEntity.ok(senduser);
		} else {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
	}
	
	@PostMapping("/saveuser")
	public ResponseEntity<?> saveUser(@RequestBody Owner user) {
		Owner u=dao2.findByUsername(user.getUsername());
		if(u!=null) {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();	
		}
		else {
			dao2.save(user);
			return ResponseEntity.ok(user);
		}
	}
	
	@PostMapping("/addOwner")
	public ResponseEntity<Owner> addOwner(@Valid @RequestBody Owner e) {

		return new ResponseEntity<Owner>(service.addOwner(e), HttpStatus.CREATED);
	}
	@GetMapping("findOwner/{ownerId}")
	public ResponseEntity<Owner> getOwnerById(@PathVariable("ownerId") int ownerId) {
		return new ResponseEntity<Owner>(service.getOwnerById(ownerId), HttpStatus.OK);
	
		
	}
	
	@PutMapping("update")
	public ResponseEntity<Owner> updateOwner(@Valid  @RequestBody Owner e) {
		return new ResponseEntity<Owner>(service.updateOwner(e),HttpStatus.OK);
	}
	
	@DeleteMapping("deleteOwner/{ownerId}")
	public ResponseEntity<Boolean> deleteOwner(@PathVariable("ownerId") int ownerId) {
		service.deleteById(ownerId);
		boolean flag = true;
		return new ResponseEntity<Boolean>(flag, HttpStatus.OK);
	}
	
	
	

}
