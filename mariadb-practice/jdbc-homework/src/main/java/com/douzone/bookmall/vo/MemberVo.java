package com.douzone.bookmall.vo;

public class MemberVo {
	private Long no;
	private String name;
	private String email;
	private String password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "회원 번호=" + no + ", 이름=" + name + ", 이메일=" + email + ", 비밀번호=" + password;
	}
	
}
