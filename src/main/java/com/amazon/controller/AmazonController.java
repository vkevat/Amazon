package com.amazon.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.model.Employee;
import com.amazon.model.FinalUser;
import com.amazon.model.Header;
import com.amazon.model.User;
import com.amazon.model.UserAddResult;
import com.amazon.serviceImpl.AmazonServiceImpl;

@RestController
@RequestMapping("/amazon")
public class AmazonController {

	private static final Logger logger = LoggerFactory.getLogger(AmazonController.class);
	
	@Autowired
	AmazonServiceImpl service;
	
	@PostMapping("/newuser")
	public ResponseEntity<Header> addAmUser(@RequestBody User user){
		logger.info("User Info - {}",user);
		Header h = new Header();
		h=service.addAmUser(user);
		if(h.getStatusCode()==1000) {
			return new ResponseEntity<Header>(h,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Header>(h,HttpStatus.NOT_FOUND);
		}
			
		}
	
	@GetMapping
	public ResponseEntity<UserAddResult> getUsers(){
		UserAddResult u = new UserAddResult();
		u = service.getUser();
		if(u.getHeader().getStatusCode()==1000) {
			return new ResponseEntity<UserAddResult>(u,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<UserAddResult>(u,HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<Header> amLogin(@RequestBody User user){
		logger.info("User Info - {}",user);
		Header h = new Header();
		h = service.amLogin(user.getUserID(),user.getPassword());
		if(h.getStatusCode()==1000) {
			return new ResponseEntity<Header>(h,HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Header>(h,HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(@RequestHeader("correlationid") String correlationid ){
		logger.info("Inside Controller - getAllEmploees()");
		return service.getAllEmployees();
		
	}
	
}
