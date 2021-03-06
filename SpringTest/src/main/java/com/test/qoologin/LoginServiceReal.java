package com.test.qoologin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.loginetc.AdverDTO;
import com.test.loginetc.AutoLoginPic;
import com.test.loginetc.Encryption;
import com.test.loginetc.Iphelper;
import com.test.loginetc.SignUpDTO;

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

	@Override
	public HttpServletRequest AutoLoginBanned(HttpServletRequest request) {
		
		HttpSession userSession = request.getSession();//유저의 세션객체를 만들어준다.
		int sucessCount = 0;//사용자가 몇번 정답을 맞췄는지 알려줄것이다.
		userSession.setAttribute("sucessCount", sucessCount);//세션객체에 대입
		
		AutoLoginPic autoLogin = new AutoLoginPic();
		String[] picNameKorEng = autoLogin.picName();//어떤 사진을 줄건지 생각을 해야한다.
		List<String> picList = autoLogin.firstCall(9,picNameKorEng[1]);//처음으로 가져와서 넘겨줄 사진
		
		
		userSession.setAttribute("selectPicName", picNameKorEng[1]);//사진이름 넘긴다. -> 영어이름 넘길것이다.
		
		request.setAttribute("picList", picList);
		request.setAttribute("picName", picNameKorEng[0]);//한글이름만 넘겨준다. -> 애는 requst 객체로 그림 한글이름만 넘겨준다.
		
		
		return request;
	}
	
	@Override
	public JSONObject picCheck(HttpServletRequest request) {
		
		HttpSession userSession = request.getSession();
		int sucessCount = (Integer) userSession.getAttribute("sucessCount");
		
		String selectPicName = (String)userSession.getAttribute("selectPicName");//정답 그림이름 -> 영어이름
	
		
		String throwPicName = request.getParameter("picName");//ajax 를 통해서 넘어온 그림의 이름 
		String clickNum = request.getParameter("clickNum");//ajax 를 통해서 넘어온 태그 id명
		
		
		if (selectPicName.equals("airplane")) {
			if (throwPicName.contains("airplane")) sucessCount++; 
		} else if (selectPicName.equals("apartment")) {
			if (throwPicName.contains("apartment")) sucessCount++; 
		} else if (selectPicName.equals("car")) {
			if (throwPicName.contains("car")) sucessCount++;
		} else if (selectPicName.equals("cat")) {
			if (throwPicName.contains("cat")) sucessCount++; 
		} else if (selectPicName.equals("dog")) {
			if (throwPicName.contains("dog")) sucessCount++; 
		} else if (selectPicName.equals("laptop")) {
			if (throwPicName.contains("laptop")) sucessCount++; 
		} else if (selectPicName.equals("phone")) {
			if (throwPicName.contains("phone")) sucessCount++; 
		} else if (selectPicName.equals("sea")) {
			if (throwPicName.contains("sea")) sucessCount++; 
		}
			
		userSession.setAttribute("sucessCount", sucessCount);//카운트를 넣어주기
		
		JSONObject obj = new JSONObject();
		Autologin al = new Autologin();
		String selectPic = al.imgMakers();//두번째로 불러올 이미지
		
		Map<Integer,String[]> map = al.picAnother(clickNum,selectPicName);
		obj.put("ansImg_1",map.get(0)[0]);
		obj.put("ansImg_1_value",map.get(0)[1]);
		obj.put("ansImg_2",map.get(1)[0]);
		obj.put("ansImg_2_value",map.get(1)[1]);
		obj.put("ansImg_3",map.get(2)[0]);
		obj.put("ansImg_3_value",map.get(2)[1]);

		
		
		obj.put("clickNum", clickNum);//클릭한 태그명
		obj.put("selectPic", selectPic);//클릭한 태그명에 새로운 사진 업데이트
		obj.put("sucessCount",sucessCount);
		
		return obj;
	}
	
	@Override
	public HashMap<String,String> adver() {//db 로부터 광고 데이터를 가져와서 어떤식으로 뿌릴지 로직을 짜주면된다.
		
		
		Random rnd = new Random();
		List<AdverDTO> dtoList = dao.getAdvertiseInfo();
		
		//금액에 맞춰서 내보내야 하지만 -> 이건 후에 지금은 "랜덤"으로 처리해준다.
		AdverDTO dto = dtoList.get(rnd.nextInt(dtoList.size()));
		String picName = dto.getAdpPcUrl();
		String url = dto.getAdUrl();
		
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("picName", picName);
		map.put("url", url);
		
		return map;
	}
	
	@Override
	public String dateTypeConvert(String input) {
		
		if (input.length() == 1) {
			input = "0" + input;
		}
		
		return input;	
	}
	

	@Override
	public int signUp(HttpServletRequest request) {
		
		
		String qoouser_id = request.getParameter("id_input");//회원가입 아이디
		String qoouser_pw = pwEnc(request.getParameter("pw_input"));//암호화 해줘야한다. -> 회원가입 비밀번호
		String qoouser_name = request.getParameter("name_input");// 회원가입 이름
		String qoouser_gender = request.getParameter("sex_input");// 회원가입 성별
		String qoouser_nation = request.getParameter("nation_input");// 회원가입 국가
		
		
		StringBuffer sb = new StringBuffer();
		sb.append(request.getParameter("yy_input"));
		sb.append("-");
		sb.append(request.getParameter("mm_input"));
		sb.append("-");
		sb.append(dateTypeConvert(request.getParameter("dd_input")));
		
		String qoouser_birthday = sb.toString();// 회원가입 생년월일
		String qoouser_phone_num = request.getParameter("phone_input");//회원가입 전화번호
		
		sb.setLength(0);//StringBuffer 객체 초기화
		sb.append(request.getParameter("email_input_address"));
		sb.append("@");
		sb.append(request.getParameter("email_input_site"));
		
		String qoouser_email = sb.toString();//회원가입 이메일주소
		String qoouser_receive_email = request.getParameter("email_agree_input");
		String qoouser_receive_sms = request.getParameter("sms_agree_input");
		
		String qoouser_ipaddress = ipCheck(request);
		
		
		SignUpDTO dto = new SignUpDTO();
		dto.setQoouser_id(qoouser_id);
		dto.setQoouser_pw(qoouser_pw);
		dto.setQoouser_name(qoouser_name);
		dto.setQoouser_gender(qoouser_gender);
		dto.setQoouser_nation(qoouser_nation);
		dto.setQoouser_birthday(qoouser_birthday);
		dto.setQoouser_phone_num(qoouser_phone_num);
		dto.setQoouser_email(qoouser_email);
		dto.setQoouser_receive_email(qoouser_receive_email);
		dto.setQoouser_receive_sms(qoouser_receive_sms);
		dto.setQoouser_ipaddress(qoouser_ipaddress);
		
		
		int result = dao.signUp(dto);

		
		return result;
	}

	@Override
	public int signUpIdVerify(HttpServletRequest request) { //회원가입 - 아이디 검증
		
		String inputId = request.getParameter("checkid");
		System.out.println(inputId);
		
		int result = dao.signUpIdVerifyCheck(inputId);
		System.out.println("============");
		System.out.println(result);
		System.out.println("============");
		
		return result;
	}
	
	
	
	
	
}
