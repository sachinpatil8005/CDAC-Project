package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entities.Subscribtion;


@Transactional
public interface SubRepo extends JpaRepository<Subscribtion, Integer> {
	
	 @Query("select s.amount from Subscribtion s where s.id_subscribtion = ?1")
	 public Integer getAmount(int sub);

}
