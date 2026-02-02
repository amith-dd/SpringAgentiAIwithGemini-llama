package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SalaryPayment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentid;
	private int employeeid;
	private double amount;
	private LocalDate paymentDate;
	public int getPaymentid() {
		return paymentid;
	}
	public void setPaymentid(int paymentid) {
		this.paymentid = paymentid;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public SalaryPayment(int paymentid, int employeeid, double amount, LocalDate paymentDate) {
		super();
		this.paymentid = paymentid;
		this.employeeid = employeeid;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}
	public SalaryPayment() {
		super();
	}
	
	
	
}
