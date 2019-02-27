package com.globocom.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.exception.GenericJDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.globocom.model.User;
import com.globocom.service.UserService;


//@CrossOrigin(origins = {"http://localhost:4200"}, maxAge = 4800, allowCredentials = "false")
@RestController

public class UserController {

	@Autowired
	UserService userservice;
	
	@PostMapping("/user")
	   public ResponseEntity<?> save(@RequestBody User user) {
			Date parsedDate = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			user.setAddtime(formatter.format(parsedDate));
			user.setUpdatetime(formatter.format(parsedDate));
			user.setPassword("5fdsf465sd465sdf");
			user.setStatus("1");
			long id = userservice.save(user);
			return ResponseEntity.ok().body("New User has been Registered with ID:" + id);
	  }
	
	@GetMapping("/user/{id}")
	   public ResponseEntity<User> get(@PathVariable("id") long id) {
	      User user = userservice.get(id);
	      return ResponseEntity.ok().body(user);
	  }
	
	@GetMapping("/user")
	   public ResponseEntity<List<User>> list() {
	      List<User> user = userservice.list();
	      return ResponseEntity.ok().body(user);
	   }
	
	@PostMapping("/login")
	public ResponseEntity<?> login(HttpServletRequest request, HttpServletResponse response ,@RequestBody User user) {
		Integer status = 403;
		String message = "";
		
		String username = user.getUsername();
		String password = user.getPassword();
		try {
		if (username == null || password == null || username.length() == 0 || password.length() == 0) {
			message = "Enter User ID and Password";
		} 
		else {
			HttpSession session = request.getSession(true);
			boolean userAuthenticated = false;
			boolean check = userservice.login(username,password);
				if(check == true) {
					userAuthenticated = true;
					status = 200;
					message = "Auth Success";
					session.setAttribute("user", username);
					session.setMaxInactiveInterval(6000);
				}
		}
	 }
		 catch (GenericJDBCException exception) {
				message = "Some problem while auth. Kindly check username and password.";
//				LOGGER.error(exception.getMessage(), exception);
			}
		Map<String, Object> map = new HashMap<>();
		map.put("message", message);
		map.put("status", status);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@PostMapping("/password")
	public ResponseEntity<?> setPassword(HttpServletRequest request, HttpServletResponse response ,@RequestBody User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		
		System.out.println(username +">>>>>>>>" + password);
		try {
			boolean check = userservice.updatePassword(username,password);
			if(check == true) {
				return ResponseEntity.ok().body("Password updated");
			}
		}catch (GenericJDBCException exception) {
	
		}
		
	
		return ResponseEntity.status(400).body("Some error occured!!");
		
	}
	
}
