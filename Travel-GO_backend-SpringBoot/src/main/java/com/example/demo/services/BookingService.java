package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Booking;
import com.example.demo.entities.Traveller;
import com.example.demo.repository.BookingRepo;

@Service
public class BookingService {
	
	@Autowired
	BookingRepo brepo;
	
	public Booking saveBooking(Booking b) {
		
		return brepo.save(b);
	}
	
	public List<Booking> getAllBooking(){
		
		return brepo.findAll();
	}
	
	public List<Booking> getBookingByTraveller(Traveller t){
		
		return brepo.getBookingByTraveller(t);
	}
}
