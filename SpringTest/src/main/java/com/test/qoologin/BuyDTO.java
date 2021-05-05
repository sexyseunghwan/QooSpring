package com.test.qoologin;

import lombok.Data;

@Data
public class BuyDTO {
	
	private int buy_qoouser_seq;
	private int product_serial;
	private int product_quantity;
	private String buy_date;
	private String buy_confirm_date;


}
