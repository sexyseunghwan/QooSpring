package com.test.qoologin;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.loginetc.Encryption;
import com.test.loginetc.Iphelper;

@Service
public class LoginServiceReal implements ILoginServiceReal{

	@Autowired
	private LoginDAO dao;

	@Override
	public String ipCheck(HttpServletRequest request) {//접속자의 아이피를 체크 지정
		
		Iphelper ip = new Iphelper();
	
		return ip.getClientIP(request);
	}

	@Override
	public String pwEnc(String password) {//접속자의 비밀번호를 변환
		
		Encryption enc = new Encryption();
		
		return enc.returnEncVoca(password);
	}

	@Override
	public int loginResult(String userIp,String id, String pw) {//로그인 결과
		// TODO Auto-generated method stub
		return dao.loginResult(userIp,id, pw);
	}
	
	
	
	
	
}
