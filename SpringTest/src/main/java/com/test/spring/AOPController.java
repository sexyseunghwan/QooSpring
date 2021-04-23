package com.test.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AOPController {
	
	
	//스프링이 자동으로 의존주입 -> 자동으로 객체만들어서 넣어준다. 
	//@Autowired
	//private IMyBatisService service;
	
	//주업무
	@RequestMapping(value = "/index.action", method = { RequestMethod.GET })
	public String index(HttpServletRequest request, HttpServletResponse response) {

		//시작 페이지
		//int count = service.getCount();
		//System.out.println("==============");
		//System.out.println(service.m1());
		//System.out.println("==============");
		//request.setAttribute("count", count);
		
		//DBUtil db = new DBUtil();
		//db.open();
		
		
		return "result";//result.jsp 를 부르게 된다.
	}
	
	@RequestMapping(value = "/index1.action", method = { RequestMethod.GET })
	public String index2(HttpServletRequest request, HttpServletResponse response) {

		//시작 페이지
		//int count = service.getCount();
		System.out.println("==============");
		//System.out.println(service.m1());
		System.out.println("==============");
		//request.setAttribute("count", count);
		
		
		
		return "result1";//result.jsp 를 부르게 된다.
	}
	
	
}
