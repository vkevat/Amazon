package com.amazon.model;

public class Phone {

	private String countryCode;
	private String phoneNo;
	private int uId;
	
	public Phone() {}
	
	public Phone(String countryCode, String phoneNo, int uId) {
		super();
		this.countryCode = countryCode;
		this.phoneNo = phoneNo;
		this.uId = uId;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	
	
	
}
