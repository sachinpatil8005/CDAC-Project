package com.example.demo.entities;

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
@Table(name = "sub_payment")
public class Sub_payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_sub_payment;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_host")
	Host id_host;
	
	@Column
	Integer amount;
	
	@Column
	String pay_mode;
	
	

	public Sub_payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Sub_payment(Host id_host, Integer amount, String pay_mode) {
		super();
		this.id_host = id_host;
		this.amount = amount;
		this.pay_mode = pay_mode;
	}



	public Integer getId_sub_payment() {
		return id_sub_payment;
	}

	public void setId_sub_payment(Integer id_sub_payment) {
		this.id_sub_payment = id_sub_payment;
	}

	public Host getId_host() {
		return id_host;
	}

	public void setId_host(Host id_host) {
		this.id_host = id_host;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getPay_mode() {
		return pay_mode;
	}

	public void setPay_mode(String pay_mode) {
		this.pay_mode = pay_mode;
	}
	

}
