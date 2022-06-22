package com.amazon.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User> {

	static int a = 0;
	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		User u = new User();
		Phone phone = new Phone();
		List<Phone> p = new ArrayList<Phone>();
		if(!(rs.getInt("ID")==a)) {
		a = rs.getInt("ID");
		u.setID(a);
		u.setFirstName(rs.getString("First_Name"));
		u.setLastName(rs.getString("Last_Name"));
		u.setUserID(rs.getString("User_ID"));
		u.setPassword(rs.getString("Password"));
		u.setConfirmPassword(rs.getString("Confirm_Password"));
		phone.setCountryCode(rs.getString("Country_code"));
		phone.setPhoneNo(rs.getString("Phone_No"));
		phone.setuId(rs.getInt("U_ID"));
		p.add(phone);
		u.setPhone(p);
		}
		else {
			phone.setCountryCode(rs.getString("Country_code"));
			phone.setPhoneNo(rs.getString("Phone_No"));
			phone.setuId(rs.getInt("U_ID"));
			p.add(phone);
			u.setPhone(p);
		}
		return u;
	}



}
