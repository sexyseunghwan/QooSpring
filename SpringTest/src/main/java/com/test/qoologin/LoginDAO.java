package com.test.qoologin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.loginetc.AdverDTO;
import com.test.loginetc.SignUpDTO;

@Repository
public class LoginDAO {
	
	@Autowired
	private SqlSessionTemplate template;
	
	
	//로그인 결과
	public int loginResult(String userIp,String id,String encpw) {
		
		Map<String, String> loginCheckMap = new HashMap<String, String>();
		
		loginCheckMap.put("userIp", userIp);
		loginCheckMap.put("id", id);
		loginCheckMap.put("encpw", encpw);
		
		int result = template.selectOne("tuning.loginVerification",loginCheckMap);
		
		return result;
	}

	//광고 넣기
	public List<AdverDTO> getAdvertiseInfo() {
		
		List<AdverDTO> dtoList = new ArrayList<AdverDTO>();//광고로 지정되어 있는 모든 리스트를 가져와주는 작업을 수행한다
		
		dtoList = template.selectList("advertiseShow");
		
		return dtoList;
	}
	
	//회원가입 해주는 메서드
	public int signUp(SignUpDTO dto) {
		
		return template.selectOne("tuning.qooSignUpsp",dto);
	}
	
	//회원가입 - 아이디 검증
	public int signUpIdVerifyCheck(String inputId) {
		
		return template.selectOne("tuning.qooSignUpspIdCheck",inputId);
	}

	
	
	//회원가입시켜주기

	
	

	
	
	
}
