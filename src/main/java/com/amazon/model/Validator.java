package com.amazon.model;

import java.util.Date;

public class Validator {

	public Header userValidate(User user) {
		
		Header h = new Header();
		
		if(!(user.getFirstName().matches(RegexConstant.firstNamePattern))) {
			h.setMsgId("First name must have minimum of 6 characters & maximum of 25 charactes and it can include Upper Case character, Lower Case character or numbers");
			h.setTimeStamp(new Date());
			h.setStatusCode(1001);
			h.setStatusDescription("Unsuccessful");
		}
		else if(!(user.getLastName().matches(RegexConstant.lastNamePattern))) {
			h.setMsgId("Last name must have minimum of 6 characters & maximum of 25 charactes and it can include have Upper Case character, Lower Case character or numbers");
			h.setTimeStamp(new Date());
			h.setStatusCode(1001);
			h.setStatusDescription("Unsuccessful");
		}
		else if(!(user.getUserID().matches(RegexConstant.userIDPattern))) {
			h.setMsgId("User ID name must have minimum of 8 characters & maximum of 15 charactes and it can include Upper Case character, Lower Case character or numbers");
			h.setTimeStamp(new Date());
			h.setStatusCode(1001);
			h.setStatusDescription("Unsuccessful");
		}
		else if(!(user.getPassword().matches(RegexConstant.passwordPattern))) {
			h.setMsgId("Password must have minimum of 8 characters & maximum of 30 charactes and it can include Upper Case character, Lower Case character, numbers & special character (. @ # $ % & ?)");
			h.setTimeStamp(new Date());
			h.setStatusCode(1001);
			h.setStatusDescription("Unsuccessful");
		}
		else if(!(user.getPassword().equals(user.getConfirmPassword()))) {
			h.setMsgId("Password & confirm password must be matched");
			h.setTimeStamp(new Date());
			h.setStatusCode(1001);
			h.setStatusDescription("Unsuccessful");
		}
		else {
			h.setMsgId("Input is correct");
			h.setTimeStamp(new Date());
			h.setStatusCode(1000);
			h.setStatusDescription("Successful");
		}
		
		return h;
		
	}
	
	public Header phoneValidate(User user) {
		Header h = new Header();
		for(Phone p : user.getPhone()) {
			if(!(p.getCountryCode().matches(RegexConstant.countryCodePattern))) {
				h.setMsgId("Country code must be +91");
				h.setTimeStamp(new Date());
				h.setStatusCode(1001);
				h.setStatusDescription("Unsuccessful");
			}
			else if(!(p.getPhoneNo().matches(RegexConstant.phoneNoPattern))) {
				h.setMsgId("Phone number must include 10 digits");
				h.setTimeStamp(new Date());
				h.setStatusCode(1001);
				h.setStatusDescription("Unsuccessful");
			}
			else {
				h.setMsgId("Input is correct");
				h.setTimeStamp(new Date());
				h.setStatusCode(1000);
				h.setStatusDescription("Successful");
			}
		}
		
		return h;
		
	}
	
}
