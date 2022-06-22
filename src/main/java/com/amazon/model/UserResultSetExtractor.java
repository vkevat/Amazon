package com.amazon.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class UserResultSetExtractor implements ResultSetExtractor<List<User>> {

	private static final Logger logger = LoggerFactory.getLogger(UserResultSetExtractor.class);
	
	@Override
	public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {

		List<User> userList = new ArrayList<User>();

		Map<Integer, User> map = new LinkedHashMap<Integer, User>();
		while (rs.next()) {

			User u = new User();
			Phone phone = new Phone();

			if (!(map.containsKey(rs.getInt("ID")))) {
				u.setID(rs.getInt("ID"));
				u.setFirstName(rs.getString("First_Name"));
				u.setLastName(rs.getString("Last_Name"));
				u.setUserID(rs.getString("User_ID"));
				u.setPassword(rs.getString("Password"));
				u.setConfirmPassword(rs.getString("Confirm_Password"));
				List<Phone> p = new ArrayList<Phone>();
				phone.setCountryCode(rs.getString("Country_code"));
				phone.setPhoneNo(rs.getString("Phone_No"));
				phone.setuId(rs.getInt("U_ID"));
				p.add(phone);
				u.setPhone(p);
				/*
				 * logger.info("Inside getuser method - {}",u);
				 * logger.trace("Inside getuser method - Trace");
				 * logger.debug("Inside getuser method - Debug");
				 * logger.warn("Inside getuser method - Warn");
				 * logger.error("Inside getuser method - Error");
				 */
				// System.out.println(u);
				map.put(rs.getInt("ID"), u);
				userList.add(u);
			}

			else {
				User u1 = map.get(rs.getInt("ID"));
				phone.setCountryCode(rs.getString("Country_code"));
				phone.setPhoneNo(rs.getString("Phone_No"));
				phone.setuId(rs.getInt("U_ID"));
				u1.getPhone().add(phone);
				// System.out.println(u1);
				// userList.add(u1);
			}

		}

		return userList;
	}

}
