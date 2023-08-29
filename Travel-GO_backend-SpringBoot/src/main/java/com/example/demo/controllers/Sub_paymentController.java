package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Host; 
import com.example.demo.entities.Sub_payment;
import com.example.demo.entities.SubpaymentSave;
import com.example.demo.services.HostService;
import com.example.demo.services.SubService;
import com.example.demo.services.Sub_paymentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Sub_paymentController {

	@Autowired
	Sub_paymentService spservice;
	
	@Autowired
	HostService hservice;
	
	@Autowired
	SubService subservice;
	
	
	@GetMapping("/getallsub_payment")
	public List<Sub_payment> getAll()
	{
		return spservice.getAllSub_payment();
	}
	
	@PostMapping("/savesubpayment")
	public Sub_payment saveSub_payment(@RequestBody SubpaymentSave sp)
	{
		
		 Host h = hservice.getHost(sp.getId_host());
		 
		 Integer id = hservice.getSubId(sp.getId_host());
		 
		 Integer am = subservice.getAmount(id);
		 
		 Sub_payment s = new Sub_payment(h, am, sp.getPayment_mode());
		 
		 return spservice.saveSub_payment(s);
		 
	}
}
