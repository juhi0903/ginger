package com.globocom.dao;

import java.util.List;

import com.globocom.model.User;

public interface UserDao {

	long saveUser(User user);

	User getUser(long id);

	List<User> getAllUsers();

	void updateUser(long id, User book);
	
	boolean submitLogin(String username, String password);

	 
}
