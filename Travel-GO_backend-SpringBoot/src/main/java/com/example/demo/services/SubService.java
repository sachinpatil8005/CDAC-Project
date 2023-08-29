package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Subscribtion;
import com.example.demo.repository.SubRepo;

@Service
public class SubService {
	
	@Autowired
	SubRepo subrepo;
	
	public List<Subscribtion> getAll()
	{
		
		return subrepo.findAll();
		
	}
	
	public Integer getAmount(int sub) {
		return subrepo.getAmount(sub);
	}


}
