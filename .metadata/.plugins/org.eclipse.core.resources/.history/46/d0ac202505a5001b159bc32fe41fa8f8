package com.test.spring;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisDAO{
	
	@Autowired
	private SqlSessionTemplate template;
	
	public void m1() {
	
		template.insert("test.m1");//namespace + id 를 적어준것이다.
		
	}

	public int m2(String seq) {
		//매개변수가 존재하는 경우
		return template.update("test.m2",seq);//이런식으로 매개변수를 넘겨줄 수 있다.
	}

	public int m3(HashMap<String, String> map) {
		
		return template.insert("test.m3",map);
	}

	public int m4(MyBatisDTO dto) {
		
		return template.insert("test.m4",dto);
	}

	public String m5() {
		
		return template.selectOne("test.m5");
	}

	public MyBatisDTO m6(String seq) {
		
		return template.selectOne("test.m6",seq);
	}

	public List<String> m7() {
		
		return template.selectList("test.m7");
	}

	public List<MyBatisDTO> m8() {
		
		return template.selectList("test.m8");
	}
	
	public int m9(String name) {
		
		return template.update("test.m9",name);
	}
	
}

