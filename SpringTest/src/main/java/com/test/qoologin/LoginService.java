package com.test.qoologin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements ILoginService{
	
	@Autowired
	private LoginDAO dao;
	

	
	@Override
	public int userMaker(String name) {
		
		//dao.userMaker(name);
		
		return 0;
	}
	
	
}
