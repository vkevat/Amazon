package com.amazon.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.amazon.model.Phone;
import com.amazon.model.User;
import com.amazon.model.UserMapper;
import com.amazon.model.UserResultSetExtractor;

@Repository
public class AmazonRepository {

	@Autowired
	JdbcTemplate jdbcTemplate;

	static int i;

	// public int addUser(User user) {
	// return jdbcTemplate.update("insert into user(First_name, Last_Name, User_ID,
	// Password, Confirm_Password) values(?,?,?,?,?)", new Object[]
	// {user.getFirstName(),user.getLastName(),user.getUserID(),user.getPassword(),user.getConfirmPassword()});
	// }

	public int addUser(User user) {
		KeyHolder holder = new GeneratedKeyHolder();
		// System.out.println("Print......");
		int a = jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(
						"insert into user(First_Name, Last_Name, User_ID, Password, Confirm_Password) values(?,?,?,?,?)",
						Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, user.getFirstName());
				ps.setString(2, user.getLastName());
				ps.setString(3, user.getUserID());
				ps.setString(4, user.getPassword());
				ps.setString(5, user.getConfirmPassword());
				// ps.executeUpdate();
				return ps;
			}
		}, holder);
		// System.out.println("Print........" + a);
		i = holder.getKey().intValue();
		// System.out.println("Print......" + i);
		return a;
	}

	public int addPhone(Phone phone) {
		return jdbcTemplate.update("insert into phone(Country_Code, Phone_No, U_ID) values(?,?,?)",
				new Object[] { phone.getCountryCode(), phone.getPhoneNo(), i });
	}

	public List<User> getUsers() {
		return jdbcTemplate.query(
				"select u.ID, u.First_Name, u.Last_Name, u.User_ID, u.Password, u.Confirm_Password, p.Country_Code, p.Phone_No, p.U_ID from user u, phone p where u.ID=p.U_ID",
				new UserMapper());
	}
	
	public List<User> getUser() {
		List<User> u = jdbcTemplate.query(
				"select u.ID, u.First_Name, u.Last_Name, u.User_ID, u.Password, u.Confirm_Password, p.Country_Code, p.Phone_No, p.U_ID from user u, phone p where u.ID=p.U_ID",
				new UserResultSetExtractor());
		return u;
	}

	public User amLogin(String userID, String password) {
		return jdbcTemplate.queryForObject("select * from user where User_ID=? and Password=?", new BeanPropertyRowMapper<User>(User.class), new Object[] {userID,password});
	}

}
