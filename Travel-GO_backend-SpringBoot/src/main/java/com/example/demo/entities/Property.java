package com.example.demo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "properties")
public class Property {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id_property;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_host")
	Host id_host;
	
	@Column
	String address;
	
	@Column
	String state;
	
	@Column
	String city;
	
	@Column
	Integer price;
	
	@Column
	byte[] pictures;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_ammenity")
	Ammenity id_ammenity;

	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Property(Host host_id, String address, String state, String city, Integer price,
			Ammenity id_ammenity) {
		super();
 		this.id_host = host_id;
		this.address = address;
		this.state = state;
		this.city = city;
		this.price = price;
		this.id_ammenity = id_ammenity;
	}



	public Integer getId_property() {
		return id_property;
	}

	public void setId_property(Integer id_property) {
		this.id_property = id_property;
	}

	public Host getHost_id() {
		return id_host;
	}

	public void setHost_id(Host host_id) {
		this.id_host = host_id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Ammenity getId_ammenity() {
		return id_ammenity;
	}

	public void setId_ammenity(Ammenity id_ammenity) {
		this.id_ammenity = id_ammenity;
	}

	public Host getId_host() {
		return id_host;
	}

	public void setId_host(Host id_host) {
		this.id_host = id_host;
	}

	public byte[] getPictures() {
		return pictures;
	}

	public void setPictures(byte[] pictures) {
		this.pictures = pictures;
	}
	
	

}
