package com.ss.model;

public class Userinfo {
	private Integer userid;
	private String username;
	private  Integer accountid;
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getAccountid() {
		return accountid;
	}
	public void setAccountid(Integer accountid) {
		this.accountid = accountid;
	}
	@Override
	public String toString() {
		return "Userinfo [userid=" + userid + ", username=" + username + ", accountid=" + accountid + "]";
	}
	public Userinfo(Integer userid, String username, Integer accountid) {
		this.userid = userid;
		this.username = username;
		this.accountid = accountid;
	}
	public Userinfo() {
	}
	
}
