package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Ammenity;
import com.example.demo.services.AmmenityService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AmmenityController {
	
	@Autowired
	AmmenityService aservice;
	
	@GetMapping("/getallammenity")
	public List<Ammenity> getAll()
	{
		return aservice.getAll();
	}
	
	@PostMapping("/saveammenity")
	public Ammenity save(@RequestBody Ammenity a)
	{
		return aservice.saveAmmenity(a);
	}
	
	
	

}
