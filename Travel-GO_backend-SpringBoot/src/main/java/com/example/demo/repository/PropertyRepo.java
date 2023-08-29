package com.example.demo.repository;

 
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Host;
import com.example.demo.entities.Property;

@Repository
@Transactional
public interface PropertyRepo extends JpaRepository<Property, Integer> {
	
	 
	@Query("select p from Property p where id_host = ?1")
	public List<Property> getPropsById(Host h);
	
	
	@Modifying
	@Query("update Property set pictures=:file where id_property=:id_property")
	public Integer uploadImage(Integer id_property,byte[] file);
	
	
}
