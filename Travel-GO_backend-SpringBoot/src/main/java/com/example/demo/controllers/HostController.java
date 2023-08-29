package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.entities.*;
import com.example.demo.services.HostService;
import com.example.demo.services.LoginService;
import com.example.demo.services.SubService;
import com.example.demo.services.Sub_paymentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class HostController {
	
	@Autowired
	HostService hservice;
	
	@Autowired
	LoginService sservice;
	
	@Autowired
	SubService subservice;
	
	@Autowired
	Sub_paymentService sub_payment;
	
	
	@GetMapping("/getallhost")
	public List<Host> getAll()
	{
		return hservice.getAll();
	}
	
	
	@PostMapping("/reghost")
	public Host regHost(@RequestBody RegHost h)
	{
		
		Login l = new Login(h.getName(), h.getPassword(), 1);
		Login saved = sservice.save(l);
		
		Integer i = h.getSub_id();
		Integer count = 0;
		
		if(i == 1)
			count = 3;
		else
			count = 5;
			
		
		Host ht = new Host(h.getName(), h.getPassword(), h.getEmail(), h.getGender(), h.getSub_id(), count, saved);
		
		hservice.saveHost(ht);
		
		Integer am = subservice.getAmount(ht.getSub_id());
		
		Sub_payment s = new Sub_payment(ht, am, h.getPayment_mode());
		
		sub_payment.saveSub_payment(s);
		
		return ht;
	}
	
	@GetMapping("/gethostid")
	public Host getHostId(@RequestParam("id")int id) {
		
		return hservice.getHost(id);
	}
	
	
	@GetMapping("/getloggedHost")
	public Host getLoggedTraveller(@RequestParam("id") Integer logid) {
		
		return hservice.getLoggedHost(logid);
	}
	

}
