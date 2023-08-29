package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.RegTraveller;
import com.example.demo.entities.*;
import com.example.demo.services.LoginService;
import com.example.demo.services.TravellerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TravellerController {

	@Autowired
	TravellerService tservice;
	
	@Autowired
	LoginService sservice;
	
	@GetMapping("/getalltraveller")
	public List<Traveller> getAllTraveller()
	{
		return  tservice.getAllTraveller();
	}
	
	@PostMapping("/regtraveller")
	public Traveller regTraveller(@RequestBody RegTraveller t)
	{
		Login l = new Login(t.getName(), t.getPassword(), 2);
		
		Login saved = sservice.save(l);
		
		Traveller travel = new Traveller(t.getName(), t.getPassword(), t.getGender(), t.getEmail(), saved);
		
		return tservice.saveTraveller(travel);
	}
	
	@GetMapping("/getloggedTraveller")
	public Traveller getLoggedTraveller(@RequestParam("id") Integer logid) {
		
		return tservice.getLoggedTraveller(logid);
	}
}
