package com.test.spring;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MyBatisDAO {
	
	@Autowired
	private SqlSessionTemplate template;//myBatis -> Statement + resultSet역할 근데 또 애한테 의존하므로 의존주입 해야함
	
	public String m1() {
		
		//진짜 db 작업 수행해주면 된다.
		
//		stat.executeUpdate
//		- template.insert();
//		- template.update();
//		- template.delete();
		
//		stat.executeQuery
//		- template.select();
		
		//test.m1
		// -> 매퍼에 있는 쿼리들 중 네임스페이스가 test 이고 id 가 m1인 쿼리를 찾아서 호출해라.
		// 
		return template.selectOne("test.m1");
		
	}
	
}
