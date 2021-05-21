package com.douzone.bookmall.vo;

public class OrderBookVo {
	private int count;
	private int price;
	private String orderNo;
	private String bookNo;
	private String title;
	

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getBookNo() {
		return bookNo;
	}
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
	}
	@Override
	public String toString() {
		return "도서번호="+bookNo+", 도서제목=" + title +", 수량=" + count + ", 가격=" + price ;
	}

	
}
