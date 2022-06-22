package com.amazon.model;

import java.util.List;

public class FinalUser {

	User user;
	List<Phone> phone;
	
	public FinalUser(User user, List<Phone> phone) {
		super();
		this.user = user;
		this.phone = phone;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Phone> getPhone() {
		return phone;
	}
	public void setPhone(List<Phone> phone) {
		this.phone = phone;
	}
	
	
	
}
