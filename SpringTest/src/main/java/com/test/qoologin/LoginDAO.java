package com.test.qoologin;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {

	@Autowired
	private SqlSessionTemplate template;
	
	
//	public int userMaker(String name) {
//		
//		return template.insert("tuning.s1",name);
//				
//	}
	
	
}
