package com.test.qoologin;

import java.util.Random;

public class UserMakerTool {
	
	private static Random rnd = new Random();
	
	public static String getName() {
		
		int vocaLen = rnd.nextInt(10)+10;
		
		StringBuffer sb = new StringBuffer();
		
		for (int i = 0; i < vocaLen; i++) {
			sb.append((char)(rnd.nextInt(26)+65));
		}
		
		return sb.toString();
		
	}
	
	
	public static void main(String[] args) {
		
		// 65 ~ 90 까지만 
		//System.out.println((char)65);
		
		//System.out.println(getName());
		
		
	}

}
