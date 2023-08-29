package com.example.demo.services;

 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Admin;
import com.example.demo.repository.AdminRepo;

@Service
public class AdminService {

	@Autowired
	AdminRepo Arepo;
	
	public List<Admin>getall()
	{
		return Arepo.findAll();
	}
}