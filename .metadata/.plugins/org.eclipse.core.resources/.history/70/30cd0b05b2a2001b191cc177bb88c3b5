package com.test.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBatisService implements IMyBatisService {
	
	//MyBatisService 도  DAO 를 의존해야한다 -> 의존주입이 필요함. 
	@Autowired
	private MyBatisDAO dao;
	
	@Override
	public String m1() {
		//dao 한테 일을 맡긴다.
		return dao.m1();
		
	}
	
}
