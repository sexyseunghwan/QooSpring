package com.test.qoologin;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.loginetc.AdverDTO;
import com.test.pwenc.Encmatrix;

@Controller
public class MainController {
	
	@Autowired
	private LoginService service;
	
	@Autowired
	private ITuningService iservice;
	
	@Autowired
	private ILoginServiceReal logService;
	
	//타일즈 테스트
	@RequestMapping(value = "/tiles.action", method = { RequestMethod.GET })
	public String tiles(HttpServletRequest request, HttpServletResponse response) {
		

		
		return "tilestest";
	}
	
	
	
	//처음에 로그인 페이지로 보내주는 곳
	@RequestMapping(value = "/login.action", method = { RequestMethod.GET })
	public String login(HttpServletRequest request, HttpServletResponse response) {
		
		
		//광고관련 넘겨야 한다. & 아이디 비밀번호 오류관련
		Map<String,String> adverMap = logService.adver();
		request.setAttribute("adverMap", adverMap);

		
		return "qoolog";
	}
	
	
	//처음에 로그인 페이지로 보내주는 곳
	@RequestMapping(value = "/loginVerification.action", method = { RequestMethod.POST })
	public String loginVerification(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
			
			request.setCharacterEncoding("UTF-8");
		
			String id = (String)request.getParameter("id");//아이디
			String pw = (String)request.getParameter("pw");//비밀번호
		
			String ip = logService.ipCheck(request);//ip check를 해준다.
			String encPw = logService.pwEnc(pw);//상대방이 입력한 pw를 암호화작업해준다.
			
			int loginResult = logService.loginResult(ip, id, encPw);
			
			
			if (loginResult == 0) {// 로그인 성공
				System.out.println("로그인 성공");
				return "qoolog";
			} else if (loginResult == 1 || loginResult == -1) {//로그인 실패 : 잘못된 로그인 정보 and 벤당한 아이피 들어오는경우
				System.out.println("잘못된 로그인 정보");
				
				//아래에서 광고정보를 쇄신해준다. & 아이디 비밀번호 오류관련
				Map<String,String> adverMap = logService.adver();
				request.setAttribute("adverMap", adverMap);
				request.setAttribute("loginError", 404);
				
				System.out.println("여기왔다는건데 쉬벌");
				
				return "qoolog";
			} else {//보안정책을 따라야하는 경우
				System.out.println("보안정책을 따라야한다.");
				
				request = logService.AutoLoginBanned(request);
				//여기서 보안정책에 대해 성공한 경우는 또 로그인기록등을 남겨줘야 한다.
				
				
				
				return "autologin";
			}	
	}
	
	@RequestMapping(value = "/autologinCheck.action", method = { RequestMethod.POST })
	public void autologinCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
		PrintWriter out = response.getWriter();
		JSONObject obj = logService.picCheck(request);
		
		out.print(obj);			
	}
	
	//회원가입 페이지
	@RequestMapping(value = "/signUp.action", method = { RequestMethod.GET })
	public String signUp(HttpServletRequest request, HttpServletResponse response) {
			
			
		return "qoosignup";
	}
	
	//회원가입 페이지
	@RequestMapping(value = "/signUpGo.action", method = { RequestMethod.POST })
	public String signUpGo(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		
		request.setCharacterEncoding("UTF-8");
	
		
		int result = logService.signUp(request);
		
		System.out.println(result);
						
		return "result";
	}
	
	//회원가입 - 아이디 검증
	@RequestMapping(value = "/signUpId.action", method = { RequestMethod.GET })
	public void idVerify(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		PrintWriter out = response.getWriter();
		int result = logService.signUpIdVerify(request);
		
		out.print(result);
	}
	
	//회원가입 - 로그인 검증
	@RequestMapping(value = "/signUppw.action", method = { RequestMethod.GET })
	public void pwVerify(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//PrintWriter out = response.getWriter();
		//int result = logService.signUpIdVerify(request);
		
		
		
		
		
		//out.print(result);
	}
	
	
	
	@RequestMapping(value = "/s3.action", method = { RequestMethod.GET })
	public String s3(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Encmatrix em = new Encmatrix();
		UserMakerTool um = new UserMakerTool();
		
		
		for (int i = 0; i < 10000; i++) {
	      	
			UserDTO dto = new UserDTO();
			
			dto.setQoouser_id(um.pushId(5,6));
			
			String pw = um.getPassWord();
			um.writePw(pw);
			
			String qoouser_pw = em.returnEncVoca(pw);
			dto.setQoouser_pw(qoouser_pw);
			
			String qoouser_birthday = um.returnBirthDay();
			dto.setQoouser_birthday(qoouser_birthday);
			
			String qoouser_email = um.email();
			dto.setQoouser_email(qoouser_email);
			
			String qoouser_gender = um.gender();
			dto.setQoouser_gender(qoouser_gender);
			
			String qoouser_nation = um.pushNation();
			dto.setQoouser_nation(qoouser_nation);
			
			String qoouser_ipaddress = um.ipAddress();
			dto.setQoouser_ipaddress(qoouser_ipaddress);
			
			int qoouser_hascoin = um.getCoin();
			dto.setQoouser_hascoin(qoouser_hascoin);
			
			String qoouser_phone_num = um.getPhoneNum();
			dto.setQoouser_phone_num(qoouser_phone_num);
			
			int qoouser_grade = um.getGrade();
			dto.setQoouser_grade(qoouser_grade);
			
			String qoouser_receive_email = um.nyCheck();
			dto.setQoouser_receive_email(qoouser_receive_email);
			
			String qoouser_receive_sms = um.nyCheck();
			dto.setQoouser_receive_sms(qoouser_receive_sms);
			
			String qoouser_denide = "N";
			dto.setQoouser_denide(qoouser_denide);
			
			String qoouser_register_datetime = um.enterUserDate();
			dto.setQoouser_register_datetime(qoouser_register_datetime);
		
			String qoouser_lastlogin_datetime = um.lastEnterTime();
			dto.setQoouser_lastlogin_datetime(qoouser_lastlogin_datetime);
			
			String qoouser_lastlogin_ipaddress = um.ipAddress();
			dto.setQoouser_lastlogin_ipaddress(qoouser_lastlogin_ipaddress);

			iservice.s1(dto);
			

		
		
		}
		
		
		
		return "result";
	}
	
	@RequestMapping(value = "/s4.action", method = { RequestMethod.GET })
	public String s4(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BuyMakerTool bmt = new BuyMakerTool();
		
		for (int i = 0; i < 50000 ; i++) {
			
			BuyDTO dto = new BuyDTO();
			
			dto.setBuy_qoouser_seq(bmt.userSeq());
			dto.setProduct_serial(bmt.productSeq());
			dto.setProduct_quantity(bmt.productQuantity());
			String[] totalDate = bmt.buyDate().split("~");
			
			dto.setBuy_date(totalDate[0]);
			dto.setBuy_confirm_date(totalDate[1]);
			
			
			iservice.k1(dto);
			
		}
		
		
		
		return "result";
	}
	
	@RequestMapping(value = "/s5.action", method = { RequestMethod.GET })
	public String s5(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		BuyMakerTool bmt = new BuyMakerTool();
		
		for (int i = 0; i < 20000000 ; i++) {
			
			BuyDTO dto = new BuyDTO();
			
			dto.setBuy_qoouser_seq(bmt.userSeq());
			dto.setProduct_serial(bmt.productSeq());
			dto.setProduct_quantity(bmt.productQuantity());
			String[] totalDate = bmt.buyDate().split("~");
			
			dto.setBuy_date(totalDate[0]);
			dto.setBuy_confirm_date(totalDate[1]);
			
			
			iservice.k1(dto);
		}
		
		
		
		return "result";
	}
	
	
	
	
}
