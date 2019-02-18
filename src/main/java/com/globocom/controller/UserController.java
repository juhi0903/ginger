package com.globocom.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
	public ResponseEntity<?> login(@RequestBody User user) {
		String username = user.getUsername();
		String password = user.getPassword();
		
		boolean check = userservice.login(username,password);
		return ResponseEntity.ok().body("New User has been Registered with ID:");
  }
}
