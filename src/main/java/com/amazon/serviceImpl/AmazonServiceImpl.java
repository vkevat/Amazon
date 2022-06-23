package com.amazon.serviceImpl;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazon.model.Employee;
import com.amazon.model.Header;
import com.amazon.model.Phone;
import com.amazon.model.User;
import com.amazon.model.UserAddResult;
import com.amazon.model.Validator;
import com.amazon.repository.AmazonRepository;
import com.amazon.service.AmazonService;

import ch.qos.logback.classic.Logger;

@Service
public class AmazonServiceImpl implements AmazonService {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(AmazonServiceImpl.class);
	
	@Autowired
	AmazonRepository repository;

	String str;

	@Override
	public Header addAmUser(User user) {
		Header h = new Header();
		Header h1 = new Header();
		// User user = new User();
		Phone phone = new Phone();
		Validator v = new Validator();
		h = v.userValidate(user);
		h1 = v.phoneValidate(user);
		if ((h.getStatusCode() == 1000) && (h1.getStatusCode() == 1000)) {
			str = encryptData(user.getPassword());
			user.setFirstName(user.getFirstName());
			user.setLastName(user.getLastName());
			user.setUserID(user.getUserID());
			user.setPassword(str);
			user.setConfirmPassword(str);
			try {
				int a = repository.addUser(user);
				int b = 0;
				for (Phone p1 : user.getPhone()) {
					phone.setCountryCode(p1.getCountryCode());
					phone.setPhoneNo(p1.getPhoneNo());
					b = repository.addPhone(phone);
				}
				if ((a != 0) && (b != 0)) {
					h.setMsgId("User Added");
					h.setTimeStamp(new Date());
					h.setStatusCode(1000);
					h.setStatusDescription("Successful");
				}
			} catch (Exception e) {
				h.setMsgId("User cannot be Added");
				h.setTimeStamp(new Date());
				h.setStatusCode(1001);
				h.setStatusDescription("Unsuccessful");
			}

			return h;

		}

		return h;

	}

	@Override
	public UserAddResult getUsers() {
		Header h = new Header();
		UserAddResult u = new UserAddResult();
		List<User> l = new ArrayList<User>();
		try {
			l = repository.getUsers();
			h.setMsgId("User List:");
			h.setTimeStamp(new Date());
			h.setStatusCode(1000);
			h.setStatusDescription("Successful");
		} catch (Exception e) {
			h.setMsgId("No user available");
			h.setTimeStamp(new Date());
			h.setStatusCode(1001);
			h.setStatusDescription("Unsuccessful");
		}
		u.setHeader(h);
		u.setUser(l);
		return u;
	}

	@Override
	public String encryptData(String data) {
		try {

			MessageDigest messageDigest = MessageDigest.getInstance("SHA");

			messageDigest.update(data.getBytes());

			byte[] resultByteArray = messageDigest.digest();

			StringBuilder sb = new StringBuilder();

			for (byte b : resultByteArray) {
				sb.append(String.format("%02x", b));
			}

			return sb.toString();
		} catch (Exception e) {
			return "";
		}

	}

	@Override
	public Header amLogin(String userID, String password) {
		Header h = new Header();
		str = encryptData(password);
		try {
			User u = repository.amLogin(userID, str);
			h.setMsgId("Login Successful");
			h.setTimeStamp(new Date());
			h.setStatusCode(1000);
			h.setStatusDescription("Successful");
		} catch (Exception e) {
			h.setMsgId("Login Unsuccessful");
			h.setTimeStamp(new Date());
			h.setStatusCode(1001);
			h.setStatusDescription("Unsuccessful");
		}
		return h;
	}

	@Override
	public UserAddResult getUser() {
		Header h = new Header();
		UserAddResult u = new UserAddResult();
		List<User> l = new ArrayList<User>();
		try {
			l = repository.getUser();
			h.setMsgId("User List:");
			h.setTimeStamp(new Date());
			h.setStatusCode(1000);
			h.setStatusDescription("Successful");
		} catch (Exception e) {
			h.setMsgId("No user available");
			h.setTimeStamp(new Date());
			h.setStatusCode(1001);
			h.setStatusDescription("Unsuccessful");
		}
		u.setHeader(h);
		u.setUser(l);
		return u;
	}

	@Override
	public List<Employee> getAllEmployees() {
		logger.info("Inside Service - getAllEmployees()");
		List<Employee> e = new ArrayList<Employee>();
		Employee e1 = new Employee(1,"VK",10000);
		Employee e2 = new Employee(2,"SK",15000);
		Employee e3 = new Employee(3,"MK",13000);
		Employee e4 = new Employee(4,"KK",12000);
		Employee e5 = new Employee(5,"JK",20000);
		e=Arrays.asList(e1,e2,e3,e4,e5);
		return e;		
	}

}
