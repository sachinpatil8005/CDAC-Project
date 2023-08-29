package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Booking;
import com.example.demo.entities.Traveller;

 
public interface BookingRepo extends JpaRepository<Booking, Integer> {
	
	@Query("select b from Booking b where b.travel_id =?1")
	public List<Booking> getBookingByTraveller(Traveller t);

}
