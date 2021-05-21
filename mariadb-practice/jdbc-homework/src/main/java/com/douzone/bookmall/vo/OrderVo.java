package com.douzone.bookmall.vo;

public class OrderVo {
	private Long no;
	private String address;
	private int price;
	private String memberNo;
	private String name;
	private String email;
	private String orderNo;
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(String memberNo) {
		this.memberNo = memberNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "주문 번호=" + orderNo + ", 배송지=" + address + ", 결제금액=" + price + ", 주문자( 주문자 이름="
				+ name + ", 이메일=" + email + ")";
	}

	
}
