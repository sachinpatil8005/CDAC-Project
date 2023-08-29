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
@Table(name="booking_payment")
public class Booking_payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id_book_pay;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "booking_id")
	Booking booking_id;
	
	@Column
	String pay_mode;
	
	@Column
	Integer amount;

	public Booking_payment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking_payment(Booking booking_id, String pay_mode, Integer amount) {
		super();
		this.booking_id = booking_id;
		this.pay_mode = pay_mode;
		this.amount = amount;
	}

	public Integer getId_book_pay() {
		return id_book_pay;
	}

	public void setId_book_pay(Integer id_book_pay) {
		this.id_book_pay = id_book_pay;
	}

	public Booking getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(Booking booking_id) {
		this.booking_id = booking_id;
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
