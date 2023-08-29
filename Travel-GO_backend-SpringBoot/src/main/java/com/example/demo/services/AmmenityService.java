package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Ammenity;
import com.example.demo.repository.AmmenityRepo;

@Service
public class AmmenityService {
	
	@Autowired
	AmmenityRepo arepo;
	
	public List<Ammenity> getAll()
	{
		return arepo.findAll();
	}
	
	public Ammenity saveAmmenity(Ammenity a)
	{
		return arepo.save(a);
	}
	
	
	
	

}
