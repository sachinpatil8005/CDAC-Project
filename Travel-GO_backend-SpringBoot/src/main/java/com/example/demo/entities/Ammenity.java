package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ammenity")
public class Ammenity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_ammenity;
	@Column
	Integer rooms;
	@Column
	String home_type;
	@Column
	Integer bedrooms;
	@Column
	Boolean has_kitchen;
	@Column
	Boolean has_ac;
	@Column
	Boolean has_parking;
	@Column
	Boolean has_tv;
	@Column
	Boolean has_caretaker;
	@Column
	String summary;
	
	public Ammenity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ammenity(Integer rooms, String home_type, Integer bedrooms, Boolean has_kitchen, Boolean has_ac,
			Boolean has_parking, Boolean has_tv, Boolean has_caretaker, String summary) {
		super();
		this.rooms = rooms;
		this.home_type = home_type;
		this.bedrooms = bedrooms;
		this.has_kitchen = has_kitchen;
		this.has_ac = has_ac;
		this.has_parking = has_parking;
		this.has_tv = has_tv;
		this.has_caretaker = has_caretaker;
		this.summary = summary;
	}

	public Integer getId_ammenity() {
		return id_ammenity;
	}

	public void setId_ammenity(Integer id_ammenity) {
		this.id_ammenity = id_ammenity;
	}

	public Integer getRooms() {
		return rooms;
	}

	public void setRooms(Integer rooms) {
		this.rooms = rooms;
	}

	public String getHome_type() {
		return home_type;
	}

	public void setHome_type(String home_type) {
		this.home_type = home_type;
	}

	public Integer getBedrooms() {
		return bedrooms;
	}

	public void setBedrooms(Integer bedrooms) {
		this.bedrooms = bedrooms;
	}

	public Boolean getHas_kitchen() {
		return has_kitchen;
	}

	public void setHas_kitchen(Boolean has_kitchen) {
		this.has_kitchen = has_kitchen;
	}

	public Boolean getHas_ac() {
		return has_ac;
	}

	public void setHas_ac(Boolean has_ac) {
		this.has_ac = has_ac;
	}

	public Boolean getHas_parking() {
		return has_parking;
	}

	public void setHas_parking(Boolean has_parking) {
		this.has_parking = has_parking;
	}

	public Boolean getHas_tv() {
		return has_tv;
	}

	public void setHas_tv(Boolean has_tv) {
		this.has_tv = has_tv;
	}

	public Boolean getHas_caretaker() {
		return has_caretaker;
	}

	public void setHas_caretaker(Boolean has_caretaker) {
		this.has_caretaker = has_caretaker;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}
	
	
	
	
}
