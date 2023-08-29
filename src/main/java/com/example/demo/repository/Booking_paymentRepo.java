package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Booking_payment;

public interface Booking_paymentRepo extends JpaRepository<Booking_payment, Integer> {

}
