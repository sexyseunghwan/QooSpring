package com.test.qoologin;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TuningDAO {
	
	@Autowired
	private SqlSessionTemplate template;
	
	public void userMaker(UserDTO dto) {
		
		//System.out.println(dto.getQoouser_id());
		
		template.insert("tuning.s1",dto);
		
	}
	
	public void buyMaker(BuyDTO dto) {
		
		template.insert("tuning.s2",dto);
		
	}
	
}
