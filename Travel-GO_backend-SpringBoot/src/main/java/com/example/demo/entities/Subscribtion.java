package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name = "subscribtion")
public class Subscribtion {
	
	@Id
	Integer id_subscribtion;
	@Column
	Integer amount;
	@Column
	Integer validity;
	@Column
	Integer props;
	
	
	public Subscribtion() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Subscribtion(Integer amount, Integer validity, Integer properties) {
		super();
		this.amount = amount;
		this.validity = validity;
		this.props = properties;
	}


	public int getIdSubscribtion() {
		return id_subscribtion;
	}


	public void setIdSubscribtion(int idSubscribtion) {
		this.id_subscribtion = idSubscribtion;
	}


	public int getamount() {
		return amount;
	}


	public void setamount(int subAmount) {
		amount = subAmount;
	}


	public int getValidity() {
		return validity;
	}


	public void setValidity(int validity) {
		this.validity = validity;
	}


	public int getProperties() {
		return props;
	}


	public void setProperties(int properties) {
		this.props = properties;
	}
	
	
	
	

}
