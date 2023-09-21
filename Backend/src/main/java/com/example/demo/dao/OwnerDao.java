package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Owner;




@Repository
public interface OwnerDao extends JpaRepository<Owner, Integer>
{
	public Owner findByUsername(String owner_username);
}