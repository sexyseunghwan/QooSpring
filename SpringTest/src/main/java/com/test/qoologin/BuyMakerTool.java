package com.test.qoologin;

import java.util.Calendar;
import java.util.Random;

public class BuyMakerTool {
	
	private static Random rnd = new Random();
	
	//구매한 회원 번호
	public int userSeq() {
		
		return rnd.nextInt(2000000)+1;
		//return rnd.nextInt(20000)+1;
	}
	
	//제품 고유 번호
	public int productSeq() {
		
		return rnd.nextInt(44)+1;
	}
	
	//구매 수량
	public int productQuantity() {
		return rnd.nextInt(40)+1;
	}
	
	//구매일자 -> 구매일자 + 확정일자
	public String buyDate() {
		
		Calendar cal = Calendar.getInstance();
		
		int enterYear = rnd.nextInt(21)+2000;
		int enterMonth = rnd.nextInt(12);
		cal.set(enterYear, enterMonth,1);
		
		int endterDate = rnd.nextInt(cal.getActualMaximum(Calendar.DAY_OF_MONTH)) + 1;
		int enterHour = rnd.nextInt(24);
		int enterMin = rnd.nextInt(60);
		
		cal.set(enterYear,enterMonth,endterDate,enterHour,enterMin);
		cal.add(Calendar.DATE, rnd.nextInt(6)+1);
		
		String defaultDate = String.format("%d-%02d-%02d %02d:%02d", enterYear,enterMonth+1,endterDate,enterHour,enterMin);
		String confirmDate = String.format("%d-%02d-%02d %02d:%02d", cal.get(Calendar.YEAR),cal.get(Calendar.MONTH)+1,cal.get(Calendar.DATE),cal.get(Calendar.HOUR_OF_DAY),cal.get(Calendar.MINUTE));
		
		return defaultDate + "~" + confirmDate;
		
	}
	

	

}
