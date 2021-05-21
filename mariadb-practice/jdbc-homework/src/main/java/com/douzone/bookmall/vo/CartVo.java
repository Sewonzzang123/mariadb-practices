package com.douzone.bookmall.vo;

public class CartVo {
	private int stock;
	private int price;
	private String bookNo;
	private String MemberNo;
	private String bookTitle;
	

	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	public String getMemberNo() {
		return MemberNo;
	}
	public void setMemberNo(String memberNo) {
		MemberNo = memberNo;
	}
	@Override
	public String toString() {
		return "책이름="+bookTitle+", 수량="+stock+", 가격="+price;
	}
	

	
}
