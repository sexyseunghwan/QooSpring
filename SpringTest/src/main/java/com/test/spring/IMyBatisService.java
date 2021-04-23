package com.test.spring;

import java.util.HashMap;
import java.util.List;

public interface IMyBatisService {
	
	void m1();
	
	int m2(String seq);
	
	int m3(HashMap<String, String> map);

	int m4(MyBatisDTO dto);
	
	String m5();
	
	MyBatisDTO m6(String seq);
	
	List<String> m7();
	
	List<MyBatisDTO> m8();
	
	int m9(String name);
}
