package com.test.spring;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyBatisService implements IMyBatisService {
	
	@Autowired
	private MyBatisDAO dao;
	
	
	@Override
	public void m1() {
		//진짜 테스트용
		dao.m1();
		
	}

	
	@Override
	public int m2(String seq) {
		
		return dao.m2(seq);
	}


	@Override
	public int m3(HashMap<String, String> map) {
		
		return dao.m3(map);
	}


	@Override
	public int m4(MyBatisDTO dto) {
		// TODO Auto-generated method stub
		return dao.m4(dto);
	}


	@Override
	public String m5() {
		
		return dao.m5();
	}


	@Override
	public MyBatisDTO m6(String seq) {
		return dao.m6(seq);
	}


	@Override
	public List<String> m7() {
		
		return dao.m7();
	}


	@Override
	public List<MyBatisDTO> m8() {
		
		return dao.m8();
	}
	
	@Override
	public int m9(String name) {
		
		return dao.m9(name);
	}
	
	
	
}
