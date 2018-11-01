package com.ss.model;

public class Tradeitem {
	private Integer itemid;
	private Integer bookid;
	private Integer quantity;
	private Integer tradeid;
	public Integer getItemid() {
		return itemid;
	}
	public void setItemid(Integer itemid) {
		this.itemid = itemid;
	}
	public Integer getBookid() {
		return bookid;
	}
	public void setBookid(Integer bookid) {
		this.bookid = bookid;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getTradeid() {
		return tradeid;
	}
	public void setTradeid(Integer tradeid) {
		this.tradeid = tradeid;
	}
	@Override
	public String toString() {
		return "Tradeitem [itemid=" + itemid + ", bookid=" + bookid + ", quantity=" + quantity + ", tradeid=" + tradeid
				+ "]";
	}
	public Tradeitem(Integer itemid, Integer bookid, Integer quantity, Integer tradeid) {
		this.itemid = itemid;
		this.bookid = bookid;
		this.quantity = quantity;
		this.tradeid = tradeid;
	}
	public Tradeitem() {
	}
	
}	
