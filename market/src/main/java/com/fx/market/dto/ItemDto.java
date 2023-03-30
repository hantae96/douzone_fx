package com.fx.market.dto;

public class ItemDto {
	private String itemId;
	private String itemName;
	private Long itemPrice;
	private String itemContext;
	private String itemLocal;
	
	
	
	public ItemDto(String itemId, String itemName, Long itemPrice, String itemContext, String itemLocal) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemContext = itemContext;
		this.itemLocal = itemLocal;
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
	public Long getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(Long itemPrice) {
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
