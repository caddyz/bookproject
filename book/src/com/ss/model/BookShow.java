package com.ss.model;

public class BookShow {
	private String author;
	private String title;
	private Float price;
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
	@Override
	public String toString() {
		return "BookShow [author=" + author + ", title=" + title + ", price=" + price + "]";
	}
	public BookShow(String author, String title, Float price) {
		this.author = author;
		this.title = title;
		this.price = price;
	}
	public BookShow() {}
}
