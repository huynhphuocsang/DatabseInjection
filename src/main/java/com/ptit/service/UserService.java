package com.ptit.service;




public interface UserService {
	public boolean signIn(String username, String password); 
	public boolean signUp(String username, String password); 
}
