package com.test.qoologin;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TuningDAO {
	
	@Autowired
	private SqlSessionTemplate template;
	
	public void userMaker(UserDTO dto) {
		template.insert("tuning.s1");
		
	}	
}