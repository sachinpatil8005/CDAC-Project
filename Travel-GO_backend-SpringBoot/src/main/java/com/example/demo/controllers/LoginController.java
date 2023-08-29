package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Login;
import com.example.demo.entities.LoginCheck;
import com.example.demo.services.LoginService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	
	@Autowired
	LoginService lservice;
	
	@PostMapping("/checklogin")
	 public Login checkLogin(@RequestBody LoginCheck check) {
		 
		 return lservice.getLogin(check.getUid(), check.getPwd());
	 }
	
	@GetMapping("/getalllogs")
	public List<Login> getAll()
	{
		return lservice.getAllLogs();
	}
	
	@GetMapping("/blocklog")
	public int blockLogin(@RequestParam("id_login")int id)
	{
		return lservice.blockLogin(id);
	}
	
	public Login getlogged(Integer id) {
		
		return lservice.getLogged(id);
	}

}
