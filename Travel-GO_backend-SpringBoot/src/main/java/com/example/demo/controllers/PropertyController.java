package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entities.Host;
import com.example.demo.entities.Property;
import com.example.demo.entities.Ammenity;
import com.example.demo.entities.PropertySave;
import com.example.demo.services.AmmenityService;
import com.example.demo.services.HostService;
import com.example.demo.services.PropertyService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PropertyController {
	
	@Autowired
	PropertyService pservice;
	
	@Autowired
	AmmenityService aservice;
	
	@Autowired
	HostService hservice;
	
	@GetMapping("/getselectedproperty")
	public Property getSelectedProp(@RequestParam("id_property") int id_property) {
		
		return pservice.getSelectedProperty(id_property);
	}
	
	
	@GetMapping("/getallprops")
	public List<Property> getAll()
	{
		return pservice.getAllProperty();
	}
	
	
	@PostMapping("/saveprop")
	public Property saveProp(@RequestBody PropertySave p)
	{
		
		Host h = hservice.getHost(p.getId_host());
		
		Ammenity am = new Ammenity(p.getRooms(), p.getHome_type(), p.getBedrooms(), p.getHas_kitchen(), p.getHas_ac(), p.getHas_parking(), p.getHas_tv(), p.getHas_caretaker(), p.getSummary());
		
		Ammenity a = aservice.saveAmmenity(am);
		
		Property prop = new Property(h, p.getAddress(), p.getState(), p.getCity(), p.getPrice(), a);
		
		return pservice.saveProperty(prop);
			
	}
	
	@GetMapping("/gethostproperty")
	public List<Property> getHostProperty(@RequestParam("host") int id){
		
		Host ht = hservice.getHost(id);
		
		return pservice.getPropsById(ht);
	}
	
	
	@PostMapping(value="/uploadimage/{id_property}",consumes = "multipart/form-data")
	public boolean uploadArt(@PathVariable Integer id_property,@RequestBody MultipartFile file)
	{
		boolean flag=true;
		try
		{
			flag=pservice.uploadImage(id_property, file.getBytes());
		}
		catch(Exception e)
		{
			flag=false;
		}
		return flag;
	}
	
	
	

}
