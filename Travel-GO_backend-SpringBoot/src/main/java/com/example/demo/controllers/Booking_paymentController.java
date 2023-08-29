package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Booking_payment;
import com.example.demo.services.Booking_paymentService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class Booking_paymentController {
	
	@Autowired
	Booking_paymentService bpservice;
	
	@GetMapping("/getallbooking_payment")
	public List<Booking_payment> getAllBooking_payment(){
		
		return bpservice.getAllBooking_payment();
	}
	
	
	@PostMapping("/savebooking_payment")
	public Booking_payment save(@RequestBody Booking_payment bp)
	{
		return bpservice.saveBooking_payment(bp);
	}

}
