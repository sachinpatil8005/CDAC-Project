package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Login;
import com.example.demo.entities.Traveller;

@Transactional
public interface TravellerRepo extends JpaRepository<Traveller, Integer> {

	@Query("select t from Traveller t where t.id_login = ?1")
	public Traveller getLoggedTraveller(Login id);
	
}
