package com.douzone.bookmall.vo;

public class BookVo {
	private Long no;
	private String title;
	private int price;
	private String categoryNo;
	private String categoryName;

	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "도서번호=" + no + ", 제목=" + title + ", 가격=" + price + ", 카테고리 이름=" + categoryName;
	}
}
