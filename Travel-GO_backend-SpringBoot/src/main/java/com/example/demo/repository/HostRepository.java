package com.example.demo.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Host;
import com.example.demo.entities.Login;
import com.example.demo.entities.Traveller;

@Transactional
public interface HostRepository extends JpaRepository<Host, Integer> {
	
	@Query("select h.sub_id from Host h where h.id_host = ?1")
	public int getSubId(Integer host_id);
	
	
	@Query("select h from Host h where h.id_login = ?1")
	public Host getLoggedHost(Login id);
	
	
	
	
	
}
