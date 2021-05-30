package com.test.qoologin;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;

public interface ILoginServiceReal {

	
	String ipCheck(HttpServletRequest request);//접속자의 ip 체크
	
	String pwEnc(String password);//비밀번호 암호화
	
	int loginResult(String userIp,String id,String pw);//로그인 결과

	HttpServletRequest AutoLoginBanned(HttpServletRequest request);//자동로그인 방지를 위함

	JSONObject picCheck(HttpServletRequest request);//자동로그인 --> 그림을 계속 변경해주는것

	HashMap<String,String> adver();//광고보내주는곳
	
	//날짜형식을 바꿔주는곳
	String dateTypeConvert(String input);
	
	//회원가입 다시 해주는곳
	int signUp(HttpServletRequest request);
	
	
}
