package com.fx.market.dto;

public class SignUpDto {

	private String accounts_id;
	private String name;
	private String pw;
	private String address;
	private String email;
	
	
	public SignUpDto(String accounts_id, String name, String pw, String address, String email) {
		this.accounts_id = accounts_id;
		this.name = name;
		this.pw = pw;
		this.address = address;
		this.email = email;
	}
	public String getAccounts_id() {
		return accounts_id;
	}
	public void setAccounts_id(String accounts_id) {
		this.accounts_id = accounts_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	
}
