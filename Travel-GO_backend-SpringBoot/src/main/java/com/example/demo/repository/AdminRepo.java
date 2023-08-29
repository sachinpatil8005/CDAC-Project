package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

}
