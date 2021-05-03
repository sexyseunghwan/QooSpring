package com.test.qoologin;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Calendar;
import java.util.Random;

import com.test.pwenc.Encmatrix;

public class UserMakerTool {
	
	public static Random rnd = new Random();//랜덤객체
	
	public static void main(String[] args) throws Exception {
		
		//TuningDAO dao = new TuningDAO();
		//BufferedReader readerStaging = new BufferedReader(new FileReader("C:\\test\\tuning.txt"));
		//BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\test\\tuning.txt"));	
		
		Encmatrix em = new Encmatrix();
		
		
		for (int i = 0; i < 10; i++) {
      	
//			String qoouser_id = pushId(5,6);
//			
//			String pw = getPassWord();
//			writePw(pw);
//			
//			String qoouser_pw = em.returnEncVoca(pw);
//			String qoouser_birthday = returnBirthDay();
//			String qoouser_email = email();
//			String qoouser_gender = gender();
//			String qoouser_nation = pushNation();
//			String qoouser_ipaddress = ipAddress();
//			int qoouser_hascoin = getCoin();
//			String qoouser_phone_num = getPhoneNum();
//			int qoouser_grade = getGrade();
//			String qoouser_receive_email = nyCheck();
//			String qoouser_receive_sms = nyCheck();
//			String qoouser_denide = "N";
//			String qoouser_register_datetime = enterUserDate();
//			String qoouser_lastlogin_datetime = lastEnterTime();
//			String qoouser_lastlogin_ipaddress = ipAddress();
			//String query = String.format("insert into dbo.QOO10USER values ('%s','%s','%s','%s','%s','%s',%d)", id,pw,email,gender,nation,ipAddress,hascoin);
			
			//writer.write(query);
			//writer.newLine();
			
			
//			dao.insertTuning(qoouser_id, qoouser_pw, qoouser_birthday,qoouser_email, qoouser_gender, qoouser_nation, 
//							 qoouser_ipaddress, qoouser_hascoin,qoouser_phone_num,qoouser_grade,qoouser_receive_email,
//							 qoouser_receive_sms,qoouser_denide,qoouser_register_datetime,qoouser_lastlogin_datetime,qoouser_lastlogin_ipaddress);
		
		}
		
		//writer.close();
		
		//dao.close();
		
	}
	
	
	
	public void writePw(String pw) throws Exception {
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\test\\tuning.txt",true));	
		writer.write(pw);
		writer.newLine();
		
		writer.close();
	}

	
	//회원의 생년월일을 뽑아주는것이다.
	public  String returnBirthDay() {
		
		Calendar cal = Calendar.getInstance();
		
		int birthYear = rnd.nextInt(56) + 1960;
		int birthMenth = rnd.nextInt(12);
		cal.set(birthYear, birthMenth,1);
		
		int birthDate = rnd.nextInt(cal.getActualMaximum(Calendar.DAY_OF_MONTH)) + 1;
		
		return birthYear + "-" + (birthMenth+1) + "-" + birthDate;
	}


	//회원의 최종 로그인 시간.
	public String lastEnterTime() {
		
		Calendar cal = Calendar.getInstance();
		
		int enterYear = 2021;
		int enterMonth = rnd.nextInt(3);
		cal.set(enterYear, enterMonth,1);
		
		int endterDate = rnd.nextInt(cal.getActualMaximum(Calendar.DAY_OF_MONTH)) + 1;
		int enterHour = rnd.nextInt(24);
		int enterMin = rnd.nextInt(60);
		
		return String.format("%d-%02d-%02d %02d:%02d", enterYear,enterMonth+1,endterDate,enterHour,enterMin);
	}

	//유저의 최초 회원등록일
	public String enterUserDate() {
		
		Calendar cal = Calendar.getInstance();
		
		int enterYear = rnd.nextInt(10) + 2000;
		int enterMonth = rnd.nextInt(12);
		cal.set(enterYear, enterMonth,1);
		
		int endterDate = rnd.nextInt(cal.getActualMaximum(Calendar.DAY_OF_MONTH)) + 1;
		
		
		return enterYear + "-" + (enterMonth+1) + "-" + endterDate;
	}

	//N or Y 를 도출해주는것
	public String nyCheck() {
		
		return (rnd.nextInt(10) % 2 == 0) ? "N" : "Y";
	}
	
	//grade check 해준다
	public int getGrade() {
		
		return rnd.nextInt(10)+1;
	}

	//전화번호 생성
	public String getPhoneNum() {
		
		int frontNum = rnd.nextInt(9000)+1000;
		int behindNum = rnd.nextInt(9000)+1000;
		
		return "010" + frontNum + "" + behindNum;
		
	}

	//아이디 생성
	public String pushId(int input1,int input2) {
		
		String first = "";
		String second = "";
		
		for (int i = 0; i < input1; i++) {
			int num = rnd.nextInt(26)+97;
			
			first += "" + (char)num;
		}
		
		
		for (int i = 0; i < input2; i++) {
			
			String num = "" + rnd.nextInt(10);
			second += num;
			
		}
		
		return first + second;		
	}
	
	//비밀번호 생성
	public String getPassWord() {
		
		int pwLength = 10 + rnd.nextInt(10);//최소 비밀번호 10글자로 지정
		String getPw = "";//pw 가 될것.
		
		
		for (int i = 0; i < pwLength; i++) {
			int num = 33 + rnd.nextInt(94);
			
			getPw += (char)num;
		}
		
		return getPw;
	}
	
	
	//이메일 생성
	public String email() {
		
		String email = pushId(7,4);
		
		String[] mailAddress = {"naver.com","gmail.com","yahoo.com","hotmail.com","hanmail.com","qoo10.com"};
		
		
		
		return email + "@" + mailAddress[rnd.nextInt(mailAddress.length)];
	}
	
	//성별
	public String gender() {
		
		String[] gender = {"M","F"};
		
		return gender[rnd.nextInt(2)];
		
	}
	
	//국가
	public String pushNation() {
		
		String[] nation = {"KR","SG","CN","TW","US","JP","MY","UK","FR"};
		
		return nation[rnd.nextInt(nation.length)];
		
	}
	
	//아이피 주소
	public String ipAddress() {
		
		String ipAdd = "";
		
		for (int i = 0; i < 3; i++) {
			ipAdd += "" + rnd.nextInt(10);
		}
		
		ipAdd += ".";
		
		for (int i = 0; i < 3; i++) {
			ipAdd += "" + rnd.nextInt(10);
		}
		
		ipAdd += ".";
		
		for (int i = 0; i < 3; i++) {
			ipAdd += "" + rnd.nextInt(10);
		}
		
		ipAdd += ".";
		
		for (int i = 0; i < 3; i++) {
			ipAdd += "" + rnd.nextInt(10);
		}
		
		return ipAdd;
	}
	
	//회원 코인
	public int getCoin() {
		
		int money = 150000 + rnd.nextInt(30000000);
		
		return money;
		
	}
	
	
	
}
