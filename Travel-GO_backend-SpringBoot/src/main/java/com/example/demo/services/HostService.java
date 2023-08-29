package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Host;
import com.example.demo.entities.Login;
import com.example.demo.entities.Traveller;
import com.example.demo.repository.*;

@Service
public class HostService {
	
	@Autowired
	HostRepository hrepo;
	
	@Autowired
	LoginService lservice;
	
	
	public List<Host> getAll()
	{
		return hrepo.findAll();
	}

	public Host saveHost(Host h)
	{
		return hrepo.save(h);
	}
	
	public Host getHost(int id_host) {
		
		Optional<Host> obj = hrepo.findById(id_host);
		Host h = null;
		try
		{
			h = obj.get();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return h;
	}
	
	public Integer getSubId(int host_id) {
		
		return hrepo.getSubId(host_id);
	}
	
	
	public Host getLoggedHost(Integer logid) {
		
		Login lg = lservice.getLogged(logid);
		
		return hrepo.getLoggedHost(lg);
	}
	
}
