package com.ss.model;

import java.util.Date;

public class Trade {
	private Integer tradeid;
	private Integer userid;
	private Date tradetime;
	public Integer getTradeid() {
		return tradeid;
	}
	public void setTradeid(Integer tradeid) {
		this.tradeid = tradeid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public Date getTradetime() {
		return tradetime;
	}
	public void setTradetime(Date tradetime) {
		this.tradetime = tradetime;
	}
	@Override
	public String toString() {
		return "Trade [tradeid=" + tradeid + ", userid=" + userid + ", tradetime=" + tradetime + "]";
	}
	public Trade(Integer tradeid, Integer userid, Date tradetime) {
		this.tradeid = tradeid;
		this.userid = userid;
		this.tradetime = tradetime;
	}
	public Trade() {
	}
	
}
