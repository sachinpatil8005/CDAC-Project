package com.example.demo.entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_booking;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "prop_id")
	Property prop_id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "travel_id")
	Traveller travel_id;
	
	@Column
	Date checkin;
	
	@Column
	Date checkout;
	
	@Column
	Integer totalfare;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(Property prop_id, Traveller travel_id, Date checkin, Date checkout, Integer totalfare) {
		super();
		this.prop_id = prop_id;
		this.travel_id = travel_id;
		this.checkin = checkin;
		this.checkout = checkout;
		this.totalfare = totalfare;
	}

	public Integer getId_booking() {
		return id_booking;
	}

	public void setId_booking(Integer id_booking) {
		this.id_booking = id_booking;
	}

	public Property getProp_id() {
		return prop_id;
	}

	public void setProp_id(Property prop_id) {
		this.prop_id = prop_id;
	}

	public Traveller getTravel_id() {
		return travel_id;
	}

	public void setTravel_id(Traveller travel_id) {
		this.travel_id = travel_id;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public Integer getTotalfare() {
		return totalfare;
	}

	public void setTotalfare(Integer totalfare) {
		this.totalfare = totalfare;
	}
	
	

}
