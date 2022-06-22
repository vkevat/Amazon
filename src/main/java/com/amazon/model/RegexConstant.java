package com.amazon.model;

public class RegexConstant {

	static final String firstNamePattern = "^[A-Z][a-z0-9]{5,24}$";
	static final String lastNamePattern = "^[A-Z][a-z0-9]{5,24}$";
	static final String countryCodePattern = "^[+]91$";
	static final String phoneNoPattern = "^[0-9]{10}$";
	static final String userIDPattern = "^[A-Za-z0-9]{8,15}$";
	static final String passwordPattern = "^[A-Za-z0-9._@#$%&?]{8,30}$";
	static final String confirmPasswordPattern = "^[A-Za-z0-9._@#$%&?]{8,30}$";
	
}
