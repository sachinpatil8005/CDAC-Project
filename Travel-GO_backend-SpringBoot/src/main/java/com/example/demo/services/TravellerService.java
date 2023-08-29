package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Login;
import com.example.demo.entities.Traveller;
import com.example.demo.repository.TravellerRepo;

@Service
public class TravellerService {

	@Autowired
	TravellerRepo trepo;
	
	@Autowired
	LoginService lservice;
	
	public List<Traveller> getAllTraveller()
	{
		return trepo.findAll();
	} 
	
	public Traveller saveTraveller(Traveller t)
	{
		return trepo.save(t);
	}
	
	public Traveller getTraveller(Integer id_travel) {
		
		Optional<Traveller> obj = trepo.findById(id_travel);
		Traveller tr = null;
		try
		{
			tr = obj.get();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return tr;
	}
	
	public Traveller getLoggedTraveller(Integer logid) {
		
		Login lg = lservice.getLogged(logid);
		
		return trepo.getLoggedTraveller(lg);
	}
}
