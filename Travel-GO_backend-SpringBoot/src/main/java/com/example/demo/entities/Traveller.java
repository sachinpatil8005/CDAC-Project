package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

 
@Entity
@Table(name = "traveller")
public class Traveller {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_traveller;
	@Column
	String name;
	@Column
	String password;
	@Column
	String gender;
	@Column
	String email;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_login")
	Login id_login;
	
	
	public Traveller() {
		super();
		// TODO Auto-generated constructor stub
	}


	 


	public Traveller(String name, String password, String gender, String email, Login id_login) {
		super();
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.email = email;
		this.id_login = id_login;
	}





	public Integer getId_traveller() {
		return id_traveller;
	}


	public void setId_traveller(Integer id_traveller) {
		this.id_traveller = id_traveller;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Login getLogin_id() {
		return id_login;
	}


	public void setLogin_id(Login login_id) {
		this.id_login = login_id;
	}
	
	
	
	
}
