package com.fx.market.dto;

public class HomeDto {
	private String itemName;
	private String address;
	private String price;
	private Integer recommend;
	private String date;
	
	
	@Override
	public String toString() {
		return "HomeDto [itemName=" + itemName + ", address=" + address + ", price=" + price + ", recommend="
				+ recommend + ", date=" + date + "]";
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public Integer getRecommend() {
		return recommend;
	}
	public void setRecommend(Integer recommend) {
		this.recommend = recommend;
	}
	
	
	
}
