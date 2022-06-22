package com.amazon.model;

import java.util.List;

public class User {

	private int ID;
	private String firstName;
	private String lastName;
	private String userId;
	private String password;
	private String confirmPassword;
	private List<Phone> phone;
	
	public User() {
		
	}
	
	/*
	 * public User(String userID, String password) { super(); this.userId = userID;
	 * this.password = password; }
	 */
	
	public User(int iD, String firstName, String lastName, String userID, String password, String confirmPassword,
			List<Phone> phone) {
		super();
		ID = iD;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userId = userID;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.phone = phone;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserID() {
		return userId;
	}
	public void setUserID(String userID) {
		this.userId = userID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public List<Phone> getPhone() {
		return phone;
	}
	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [ID=" + ID + ", firstName=" + firstName + ", lastName=" + lastName + ", userId=" + userId
				+ ", password=" + password + ", confirmPassword=" + confirmPassword + ", phone=" + phone + "]";
	}
	
	
}
