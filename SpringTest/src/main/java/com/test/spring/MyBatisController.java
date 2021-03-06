package com.test.spring;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyBatisController {
	
	
	//스프링이 자동으로 의존주입 -> 자동으로 객체를 만들어서 넣어준다.
	@Autowired
	private IMyBatisService service;
	
	
	@RequestMapping(value = "/m1.action", method = { RequestMethod.GET })
	public String m1(HttpServletRequest request, HttpServletResponse response) {

		service.m1();

		return "result";
	}
	
	@RequestMapping(value = "/m2.action", method = { RequestMethod.GET })
	public String result(HttpServletRequest request, HttpServletResponse response) {

		service.m2("22");

		return "result";
	}
	
	@RequestMapping(value = "/m3.action", method = { RequestMethod.GET })
	public String m3(HttpServletRequest request, HttpServletResponse response,String name, String age, String etc) {
		
		//인자값 -> 다중값 -> HashMap or DTO
		//m3.action?name=홍길동&age=20&etc=테스트용 -> 위에 매개변수에 넣어주면 된다.
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("name", name);
		map.put("age", age);
		map.put("etc", etc);
		
		
		service.m3(map);

		return "result";
	}
	
	@RequestMapping(value = "/m4.action", method = { RequestMethod.GET })
	public String m4(HttpServletRequest request, HttpServletResponse response, MyBatisDTO dto) {

		int result = service.m4(dto); 
		
		request.setAttribute("result", result);
		
		return "result";
	}
	
	@RequestMapping(value = "/m5.action", method = { RequestMethod.GET })
	public String m5(HttpServletRequest request, HttpServletResponse response) {

		String result = service.m5();
		
		request.setAttribute("result", result);
		
		return "result";
	}
	
	
	@RequestMapping(value = "/m6.action", method = { RequestMethod.GET })
	public String m6(HttpServletRequest request, HttpServletResponse response,String seq) {
		
		MyBatisDTO dto = service.m6(seq);
		
		request.setAttribute("dto", dto);
		
		return "result";
	}
	
	@RequestMapping(value = "/m7.action", method = { RequestMethod.GET })
	public String m7(HttpServletRequest request, HttpServletResponse response) {

		//List<String> names = service.m7();
		
		
		
		//request.setAttribute("names", names);
		
		return "result";
	}
	
	@RequestMapping(value = "/m8.action", method = { RequestMethod.GET })
	public String m8(HttpServletRequest request, HttpServletResponse response) {

		List<MyBatisDTO> list = service.m8();
		
		request.setAttribute("list", list);

		return "result";
	}
	
	@RequestMapping(value = "/m9.action", method = { RequestMethod.GET })
	public String m9(HttpServletRequest request, HttpServletResponse response) {

		//List<MyBatisDTO> list = service.m8();
		int answer = service.m9("qweq");
		System.out.println(answer);
		
		//request.setAttribute("list", list);

		return "result";
	}
	
	

}
