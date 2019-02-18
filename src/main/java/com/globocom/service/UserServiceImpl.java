package com.globocom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.globocom.dao.UserDao;
import com.globocom.model.User;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userdao;
	
	@Transactional
	@Override
	public long save(User user) {
		return userdao.saveUser(user);
	}

	@Override
	public User get(long id) {
		return userdao.getUser(id);
	}

	@Override
	public List<User> list() {
		return userdao.getAllUsers();
	}

	@Override
	public void update(long id, User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean login(String username, String password) {
		return userdao.submitLogin(username, password);
	}

}
