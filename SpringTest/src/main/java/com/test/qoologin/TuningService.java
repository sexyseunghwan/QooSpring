package com.test.qoologin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TuningService implements ITuningService {
	
	@Autowired
	private TuningDAO dao;
	

	@Override
	public void s1(UserDTO dto) 
	{
		
		
		//System.out.println(qoouser_id);
		
		dao.userMaker(dto);
		
	}
	
}
