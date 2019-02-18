package com.globocom.service;

import java.util.List;

import com.globocom.model.User;

public interface UserService {
	
	long save(User user);
	User get(long id);
	List<User> list();
	void update(long id, User user);
	boolean login(String username , String password);
	  
}
