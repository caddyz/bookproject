package com.ss.model;

import java.util.Date;

public class MyBook {
	private Integer id;
	private String author;
	private String title;
	private Float price;
	private Date publishingdate;
	private Integer salesamount;
	private Integer storenumber;
	private String remark;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Date getPublishingdate() {
		return publishingdate;
	}
	public void setPublishingdate(Date publishingdate) {
		this.publishingdate = publishingdate;
	}
	public Integer getSalesamount() {
		return salesamount;
	}
	public void setSalesamount(Integer salesamount) {
		this.salesamount = salesamount;
	}
	public Integer getStorenumber() {
		return storenumber;
	}
	public void setStorenumber(Integer storenumber) {
		this.storenumber = storenumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "MyBook [id=" + id + ", author=" + author + ", title=" + title + ", price=" + price + ", publishingdate="
				+ publishingdate + ", salesamount=" + salesamount + ", storenumber=" + storenumber + ", remark="
				+ remark + "]";
	}
	public MyBook(Integer id, String author, String title, Float price, Date publishingdate, Integer salesamount,
			Integer storenumber, String remark) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.price = price;
		this.publishingdate = publishingdate;
		this.salesamount = salesamount;
		this.storenumber = storenumber;
		this.remark = remark;
	}
	public MyBook() {}
}
