package com.test.qoologin;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {

	@Autowired
	private SqlSessionTemplate template;
	
	
	public int loginResult(String userIp,String id,String encpw) {
		
		Map<String, String> loginCheckMap = new HashMap<String, String>();
		
		loginCheckMap.put("userIp", userIp);
		loginCheckMap.put("id", id);
		loginCheckMap.put("encpw", encpw);
		
		
		return template.selectOne("tuning.loginVerification",loginCheckMap);
	}
	
	
	
}
