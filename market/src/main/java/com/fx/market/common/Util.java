package com.fx.market.common;

public class Util {
	    public static String priceAddComma(String price) {
	    	price = price.replaceAll("\\B(?=(\\d{3})+(?!\\d))", ",");
	        return price;
	}
}
