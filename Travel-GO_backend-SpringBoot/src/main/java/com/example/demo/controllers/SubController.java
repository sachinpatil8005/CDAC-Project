package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Subscribtion;
import com.example.demo.services.SubService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class SubController {
	
	@Autowired
	SubService service;
	
	@GetMapping("/getallsub")
	public List<Subscribtion> getAll()
	{
		
		return service.getAll();
		
	}
	
	
}
