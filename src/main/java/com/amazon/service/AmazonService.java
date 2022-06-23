package com.amazon.service;

import java.util.List;

import com.amazon.model.Employee;
import com.amazon.model.Header;
import com.amazon.model.User;
import com.amazon.model.UserAddResult;

public interface AmazonService {

	public Header addAmUser(User user);
	public UserAddResult getUsers();
	public UserAddResult getUser();
	public String encryptData(String data);
	public Header amLogin(String userID, String password);
	public List<Employee> getAllEmployees();
}
