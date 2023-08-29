package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Sub_payment;
import com.example.demo.repository.Sub_paymentRepo;

@Service
public class Sub_paymentService {
	
	@Autowired
	Sub_paymentRepo sprepo;
	
	
	public List<Sub_payment> getAllSub_payment()
	{
		return sprepo.findAll();
	} 
	
	public Sub_payment saveSub_payment(Sub_payment h)
	{
		return sprepo.save(h);
	}
}
