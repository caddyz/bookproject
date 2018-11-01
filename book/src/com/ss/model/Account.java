package com.ss.model;

public class Account {
	private Integer accountid;
	private Float balance;
	public Integer getAccountid() {
		return accountid;
	}
	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}
	public Float getBalance() {
		return balance;
	}
	public void setBalance(Float balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", balance=" + balance + "]";
	}
	public Account(Integer accountid, Float balance) {
		this.accountid = accountid;
		this.balance = balance;
	}
	public Account() {
	}
	
}
