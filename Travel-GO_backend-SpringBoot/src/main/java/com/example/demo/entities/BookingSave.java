package com.example.demo.entities;

import java.sql.Date;

public class BookingSave {
	
	Integer travel_id;
	
	Integer prop_id;

	Date checkin;
	
	Date checkout;
	
	Integer totalfare;
	
	
	
	
	String pay_mode;
	

	Integer amount;


	public Integer getTravel_id() {
		return travel_id;
	}


	public void setTravel_id(Integer travel_id) {
		this.travel_id = travel_id;
	}


	public Integer getProp_id() {
		return prop_id;
	}


	public void setProp_id(Integer prop_id) {
		this.prop_id = prop_id;
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
 

	public String getPay_mode() {
		return pay_mode;
	}


	public void setPay_mode(String pay_mode) {
		this.pay_mode = pay_mode;
	}


	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}
