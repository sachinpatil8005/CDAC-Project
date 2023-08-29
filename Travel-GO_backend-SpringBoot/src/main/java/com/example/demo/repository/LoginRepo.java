package com.example.demo.repository;

 
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Login;


@Transactional
public interface LoginRepo extends JpaRepository<Login, Integer> {
	
	
	
	@Query("select l from Login l where name = ?1 and password = ?2")
	public Optional<Login> getLogin(String name, String password);
	
	
	@Modifying
	@Query("update Login l set l.status=0 where id_login = :id")
	public int blockLogin(int id);
 

}
