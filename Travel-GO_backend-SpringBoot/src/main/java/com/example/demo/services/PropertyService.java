package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Host;
import com.example.demo.entities.Property;
import com.example.demo.repository.PropertyRepo;

@Service
public class PropertyService {
	
	@Autowired
	PropertyRepo prepo;
	
	public List<Property> getAllProperty()
	{
		return prepo.findAll();
	}
	
	public Property saveProperty(Property p) {
		
		return prepo.save(p);
	}
	
	public Property getSelectedProperty(int id) {
		
		Optional<Property> obj = prepo.findById(id);
		Property p = null;
		try
		{
			p = obj.get();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return p;
	}
	
	
	public List<Property> getPropsById(Host h){
		
		return prepo.getPropsById(h);
	}
	 
	
	public boolean uploadImage(Integer  id_property,byte[] file)
	{
		if(prepo.uploadImage( id_property, file)==1)
			return true;
		else
			return false;
	}

}
