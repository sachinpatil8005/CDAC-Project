 package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.*;
import com.example.demo.services.BookingService;
import com.example.demo.services.Booking_paymentService;
import com.example.demo.services.PropertyService;
import com.example.demo.services.TravellerService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {
	
	@Autowired
	BookingService bservice;
	
	@Autowired
	TravellerService tservice;
	
	@Autowired
	PropertyService pservice;
	
	@Autowired
	Booking_paymentService bpservice;
	
	
	@GetMapping("/getallbooking")
	public List<Booking> getAllbooking()
	{
		return bservice.getAllBooking();
	}
	
	
	@PostMapping("/savebooking")
	public Booking saveBooking(@RequestBody BookingSave b)
	{
		
		Traveller t = tservice.getTraveller(b.getTravel_id());
		
		Property p =pservice.getSelectedProperty(b.getProp_id());
		
		Booking book = new Booking(p,t,b.getCheckin(),b.getCheckout(),b.getTotalfare());
		
		Booking bk = bservice.saveBooking(book);
		
		Booking_payment bpay = new Booking_payment(bk,b.getPay_mode(),b.getAmount());
		
		
		
		bpservice.saveBooking_payment(bpay);
			
		
		return book;
	}
	
	@GetMapping("/getbookingbytrveller")
	public List<Booking> getBookin(Integer t){
		
		Traveller tr = tservice.getTraveller(t);
		
		return bservice.getBookingByTraveller(tr);
		
	}
	
	

}
