package com.fx.market.dto;

public class ItemDto {
	private String itemId;
	private String itemName;
	private String itemPrice;
	private String itemContext;
	private String itemLocal;
	private int view;
	private int recommend;
	private String date;
	
	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	// ItemDao 에서 사용하는 생성
	public ItemDto() {}
	
	
	// home 화면에서 사용하는 ItemDto
	public ItemDto(String itemName, String itemPrice, String itemContext, String itemLocal) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemContext = itemContext;
		this.itemLocal = itemLocal;
	}
	// 세부 화면에서 사용하는 ItemDto
	public ItemDto(String itemName, String itemPrice, String itemContext, String itemLocal,int view,int recommend) {
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemContext = itemContext;
		this.itemLocal = itemLocal;
		this.view = view;
		this.recommend = recommend;
	}
	
	
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemContext() {
		return itemContext;
	}
	public void setItemContext(String itemContext) {
		this.itemContext = itemContext;
	}
	public String getItemLocal() {
		return itemLocal;
	}
	public void setItemLocal(String itemLocal) {
		this.itemLocal = itemLocal;
	}
	
	

}
