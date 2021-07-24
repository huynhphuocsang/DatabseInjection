package com.ptit.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ptit.repository.UserDao;
import com.ptit.service.UserService;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	UserDao userDao; 
	
	@Override
	public boolean signIn(String username, String password) {
		return userDao.signIn(username, password); 
	}

	@Override
	public boolean signUp(String username, String password) {
		return userDao.signUp(username, password);
	}

}
