package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Login;
import com.example.demo.repository.LoginRepo;

@Service
public class LoginService {
	
	@Autowired
	LoginRepo lrepo;
	
	
	public List<Login> getAllLogs()
	{
		return lrepo.findAll();
	}
	
	
	 public Login getLogin(String name, String password) {
		 
		 Login l;
		 
		 Optional<Login> logs = lrepo.getLogin(name, password);
		 
		 try {
			 
			 l = logs.get();
			 
		 }catch(Exception e) {
			 
			 l = null;
		 }
		 
		 return l;
	 }
	
	 
	
	public Login save(Login l) {
		return lrepo.save(l);
	}
	

	public int blockLogin(int id)
	{
		return lrepo.blockLogin(id);
	}
	
	public Login getLogged(Integer id) {
		 
		 Login l;
		 
		 Optional<Login> logs = lrepo.findById(id);
		 
		 try {
			 
			 l = logs.get();
			 
		 }catch(Exception e) {
			 
			 l = null;
		 }
		 
		 return l;
	 }

}
