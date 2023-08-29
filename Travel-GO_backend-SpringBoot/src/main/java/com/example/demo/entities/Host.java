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
@Table(name="host")
public class Host {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_host;
	
	@Column
	String name;
	 
	@Column
	String password;
	 
	@Column
	String gender;
	 
	@Column
	String email;
	 
	@Column
    Integer sub_id;
	 
	@Column
	Integer count;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_login")
	Login id_login;
	
	
	public Host() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Host(String name, String password, String gender, String email, Integer sub_id, Integer count, Login id_login) {
		super();
		this.name = name;
		this.password = password;
		this.gender = gender;
		this.email = email;
		this.sub_id = sub_id;
		this.count = count;
		this.id_login = id_login;
	}

	public Integer getId_host() {
		return id_host;
	}

	public void setId_host(Integer id_host) {
		this.id_host = id_host;
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

	public Integer getSub_id() {
		return sub_id;
	}

	public void setSub_id(Integer sub_id) {
		this.sub_id = sub_id;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Login getId_login() {
		return id_login;
	}

	public void setId_login(Login id_login) {
		this.id_login = id_login;
	}

	
	
	 
	 
	

}
