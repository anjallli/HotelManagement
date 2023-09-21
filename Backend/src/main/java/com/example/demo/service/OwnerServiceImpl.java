package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dao.OwnerDao;

import com.example.demo.entity.Owner;
import com.example.demo.exception.ResourceNotFoundException;
@Service
public class OwnerServiceImpl implements OwnerService
{
@Autowired
OwnerDao dao;
	
	@Override
	public List<Owner> findAllOwner() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	@Override
	public Owner addOwner(Owner e) {
		System.out.println("Owner added Succesfully "+e);
		Owner existingProduct=dao.findById(e.getOwnerId()).orElse(null);
		
		if(existingProduct==null)
		{	
			e.setOwnerName(e.getOwnerName());
			e.setOwnerEmailId(e.getOwnerEmailId());
			e.setOwnerContactNumber(e.getOwnerContactNumber());
			e.setOwnerAddress(e.getOwnerAddress());

			return dao.save(e);
		}
		else
		{
			throw new ResourceNotFoundException("Owner already exist");
		}
	}
	
	@Override
	public Owner getOwnerById(int id) {
		// TODO Auto-generated method stub
		return this.dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("Owner not exist with id :" + id));

	}
	@Override
	public Owner updateOwner(Owner e) {
		Owner existingOwner=dao.findById(e.getOwnerId()).orElseThrow(() -> new ResourceNotFoundException("Owner not exist with id :"));
		existingOwner.setOwnerName(e.getOwnerName());
		existingOwner.setOwnerEmailId(e.getOwnerEmailId());
		existingOwner.setOwnerContactNumber(e.getOwnerContactNumber());
		existingOwner.setOwnerAddress(e.getOwnerAddress());
		
		
		
		return dao.save(existingOwner);
	}
	@Override
	public String deleteById(int id) {
		Owner existsID=dao.findById(id).orElse(null);
		if(existsID!=null)
		{
		dao.deleteById(id);
		return "Owner deleted!!";
		}
		else
		{
		throw new ResourceNotFoundException("Owner id not available");

		}
	}
	@Override
	public Owner findByUsername(String uname) {
		// TODO Auto-generated method stub
		return dao.findByUsername(uname) ;
	}
	@Override
	public ResponseEntity<?> saveUser(Owner user) {
		Owner u=dao.findByUsername(user.getUsername());
		if(u!=null) {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();	
		}
		else {
			dao.save(user);
			return ResponseEntity.ok(user);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody Owner userData) {
		Owner user = dao.findByUsername(userData.getUsername());

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

	

}
