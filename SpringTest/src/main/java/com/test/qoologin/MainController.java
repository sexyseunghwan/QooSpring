package com.test.qoologin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.test.pwenc.Encmatrix;

@Controller
public class MainController {
	
	@Autowired
	private LoginService service;
	
	@Autowired
	private ITuningService iservice;
	
	@RequestMapping(value = "/s1.action", method = { RequestMethod.GET })
	public String s1(HttpServletRequest request, HttpServletResponse response) {
		
		
		HttpSession userSession = request.getSession();//유저의 세션객체를 만들어준다.
		int sucessCount = 0;//사용자가 몇번 정답을 맞췄는지 알려줄것이다.
		userSession.setAttribute("sucessCount", sucessCount);//세션객체에 대입
		
		Autologin autoLogin = new Autologin();
		String[] picNameKorEng = autoLogin.picName();//어떤 사진을 줄건지 생각을 해야한다.
		List<String> picList = autoLogin.firstCall(9,picNameKorEng[1]);//처음으로 가져와서 넘겨줄 사진
		
		
		userSession.setAttribute("selectPicName", picNameKorEng[1]);//사진이름 넘긴다. -> 영어이름 넘길것이다.
		
		request.setAttribute("picList", picList);
		request.setAttribute("picName", picNameKorEng[0]);//한글이름만 넘겨준다. -> 애는 requst 객체로 그림 한글이름만 넘겨준다.
		
		
		
		return "autologin";
	}
	
	@RequestMapping(value = "/s2.action", method = { RequestMethod.POST })
	public void s2(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		System.out.println("여기왔다리");
		
		HttpSession userSession = request.getSession();
		int sucessCount = (Integer) userSession.getAttribute("sucessCount");
		//int sucessCount = (int)userSession.getAttribute("sucessCount");//몇번 정답을 맞췄는지 카운트해줘야한다.
		
		String selectPicName = (String)userSession.getAttribute("selectPicName");//정답 그림이름 -> 영어이름
		//System.out.println(sucessCount);
		
		String throwPicName = request.getParameter("picName");//ajax 를 통해서 넘어온 그림의 이름 
		String clickNum = request.getParameter("clickNum");//ajax 를 통해서 넘어온 태그 id명
		//System.out.println(throwPicName);
		//System.out.println(clickNum);
		
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
		
		PrintWriter out = response.getWriter();//? 이게 뭐지
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
		//나머지 사진들도 업데이트 해줘야한다.
		
		out.print(obj);	
	}
	
	
	@RequestMapping(value = "/s3.action", method = { RequestMethod.GET })
	public String s3(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Encmatrix em = new Encmatrix();
		UserMakerTool um = new UserMakerTool();
		
		
		for (int i = 0; i < 2000000; i++) {
	      	
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
		
		for (int i = 0; i < 10000000 ; i++) {
			
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
