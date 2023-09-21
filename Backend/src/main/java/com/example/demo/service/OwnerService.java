package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Owner;





public interface OwnerService 
{
	public List<Owner>findAllOwner();
	public Owner addOwner(Owner e);
	public Owner getOwnerById(int id);
	public Owner updateOwner(Owner e);
	public String deleteById(int id);
	
	public Owner findByUsername(String uname);
	public ResponseEntity<?> saveUser(@RequestBody Owner user) ;
	
}
