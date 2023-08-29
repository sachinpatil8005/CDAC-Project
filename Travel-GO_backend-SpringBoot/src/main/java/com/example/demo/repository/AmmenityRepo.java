package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Ammenity;

public interface AmmenityRepo extends JpaRepository<Ammenity, Integer> {
	
	

}
