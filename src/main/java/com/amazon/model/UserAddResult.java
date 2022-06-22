package com.amazon.model;

import java.util.List;

public class UserAddResult {

	Header header;
	List<User> user;
	
	public UserAddResult() {
		
	}
	
	public UserAddResult(Header header, List<User> user) {
		super();
		this.header = header;
		this.user = user;
	}
	public Header getHeader() {
		return header;
	}
	public void setHeader(Header header) {
		this.header = header;
	}
	public List<User> getUser() {
		return user;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
	
	
}
