package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Booking_payment;
import com.example.demo.repository.Booking_paymentRepo;

@Service
public class Booking_paymentService {
	
	@Autowired
	Booking_paymentRepo bprepo;
	
	public List<Booking_payment> getAllBooking_payment(){
		
		return bprepo.findAll();
	}
	
	public Booking_payment saveBooking_payment(Booking_payment bp)
	{
		return bprepo.save(bp);
	}
}
