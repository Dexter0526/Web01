package com.company.project.dto;

public class MemberDto {
	private String name;
	private String email;
	private String pwd;
	private String phone;
	private int admin;
	
	public MemberDto() {
		// TODO Auto-generated constructor stub
	}
	
	public MemberDto(String name, String email, String pwd, String phone, int admin) {
		super();
		this.name = name;
		this.email = email;
		this.pwd = pwd;
		this.phone = phone;
		this.admin = admin;
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
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAdmin() {
		return admin;
	}
	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	
}
