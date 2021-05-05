package com.test.qoologin;

import lombok.Data;

@Data
public class UserDTO {
	
	private String qoouser_id; 
	private String qoouser_pw; 
	private String qoouser_birthday;
	private String qoouser_email; 
	private String qoouser_gender;
	private String qoouser_nation;
	private String qoouser_ipaddress;
	private int qoouser_hascoin;
	private String qoouser_phone_num;
	private int qoouser_grade;
	private String qoouser_receive_email;
	private String qoouser_receive_sms;
	private String qoouser_denide;
	private String qoouser_register_datetime;
	private String qoouser_lastlogin_datetime;
	private String qoouser_lastlogin_ipaddress;

	
}
