package com.test.qoologin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Autologin {
	
	//랜덤함수
	private static Random rnd = new Random();
	
	
	private String[] picList = {"airplane","apartment","car","cat","dog","laptop","phone","sea"};
	
	
	public String[] picName() {
		
		String[] answerList = {"비행기","아파트","자동차","고양이","강아지","노트북","스마트폰","바다"};
		int index = rnd.nextInt(answerList.length);
		
		String[] resultArr = new String[2];
		resultArr[0] = answerList[index];
		resultArr[1] = picList[index];
		
		return resultArr;
	}
	
	
	public List<String> firstCall(int num,String imgName) {
		
		List<String> getPicList = new ArrayList<String>();
		
		//난수를 이용해서 정답하나만 넣는다.
		int ranNum = rnd.nextInt(num);
		
		for (int i = 0; i < num; i++) {
			
			if (i == ranNum) getPicList.add(imgMakers(imgName)); 
			else getPicList.add(imgMakers());
		}
		
		return getPicList;
	}
	
	//원하는 사진을 뽑아야할때
	public String imgMakers(String name) {
		
		StringBuilder st = new StringBuilder();
		st.append(name);//비행기,아파트 뭘 꺼낼건지 선택
		st.append(String.format("%02d", rnd.nextInt(10)+1));//숫자
		st.append(".jpg");
		
		return st.toString();
	}
	
	//아무사진을 뽑아도 될때
	public String imgMakers() {
		
		StringBuilder st = new StringBuilder();
		st.append(picList[rnd.nextInt(picList.length)]);//비행기,아파트 뭘 꺼낼건지 선택
		st.append(String.format("%02d", rnd.nextInt(10)+1));//숫자
		st.append(".jpg");
		
		return st.toString();
		
	}
	
	//사진 1개는 정답을 가져와주고 나머지 2개는 아무거나 가져와주자
	public Map<Integer,String[]> picAnother(String clickNum,String answer) {//imgxx,airplane
		
		Map<Integer,String[]> map = new HashMap<Integer, String[]>();
		
		List<String> seatList = new ArrayList<String>();//여기가 img1 ~ img9 까지 존재하는 곳임
		
		for (int i = 0; i < 9; i++) {
			String imgName = String.format("img%d", i+1);
			seatList.add(imgName);
		}//seatList 에 img1 ~ img9까지 String 타입으로 넣어준다.
		
		int existIndex = seatList.indexOf(clickNum);//이미 상대방이 찍은 그림번호를 제외해주기 위해서 인덱스를 꺼내준다
		seatList.remove(existIndex);//리스트에서 해당 인덱스를 제거한다. -> 여기서 오류가 발생되고 있다.
		
		//1. 정답이 존재하는 사진 -> 한장
		String[] valuesAnswer = new String[2];
		int answerPicIndex = rnd.nextInt(seatList.size());//imgxx 를 뽑기위한 인덱스 선택
		valuesAnswer[0] = seatList.get(answerPicIndex);//imgxx 뽑기
		seatList.remove(answerPicIndex);// 뽑아내서 지워준다.
		valuesAnswer[1] = imgMakers(answer);//어떤이미지 넘길건지
		map.put(0,valuesAnswer);
		
		//2. 그냥 랜덤 사진 -> 두장
		for (int i = 0; i < 2; i++) {
			String[] valuesAnswerLie = new String[2];
			int answerPicIndexLie = rnd.nextInt(seatList.size());
			valuesAnswerLie[0] = seatList.get(answerPicIndexLie);
			seatList.remove(answerPicIndexLie);//뽑아내서 지워준다.
			valuesAnswerLie[1] = imgMakers();
			map.put(i+1,valuesAnswerLie);
		}
		
		return map;
	}
	
	
}
