package com.aurionpro.entity;

public class Bank {
	private String customerEmail;
	private String customerAccountNumber;
	private String AccountType;
	public Bank(String customerEmail, String customerAccountNumber, String AccountType) {
		super();
		this.customerEmail = customerEmail;
		this.customerAccountNumber = customerAccountNumber;
		this.AccountType = AccountType;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}
	public String getCustomerAccountNumber() {
		return customerAccountNumber;
	}
	public void setCustomerAccountNumber(String customerAccountNumber) {
		this.customerAccountNumber = customerAccountNumber;
	}
	public String getAccountType() {
		return AccountType;
	}
	public void setAccountType(String AccountType) {
		this.AccountType = AccountType;
	}

}
