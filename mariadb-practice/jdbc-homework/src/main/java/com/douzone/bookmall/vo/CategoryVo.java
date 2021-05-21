package com.douzone.bookmall.vo;

public class CategoryVo {
	private Long no;
	private String name;
	
	@Override
	public String toString() {
		return "카테고리 번호=" + no + ", 카테고리명=" + name ;
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
