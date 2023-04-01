package com.fx.market.dto;

public class MySellListDto {

	private String goodsPhoto;		//판매글 사진
	private String goodsTitle;		//판매글 제목
	private String goodsAddress;	//판매 장소
	private String goodsCreated_at;	//판매글 등록 날짜
	private String goodsPrice;		//판매 가격
	private String goods_id;		//Photos_id

	public String getGoodsPhoto() {
		return goodsPhoto;
	}
	public void setGoodsPhoto(String goodsPhoto) {
		this.goodsPhoto = goodsPhoto;
	}
	public String getGoodsTitle() {
		return goodsTitle;
	}
	public void setGoodsTitle(String goodsTitle) {
		this.goodsTitle = goodsTitle;
	}
	public String getGoodsAddress() {
		return goodsAddress;
	}
	public void setGoodsAddress(String goodsAddress) {
		this.goodsAddress = goodsAddress;
	}
	public String getGoodsCreated_at() {
		return goodsCreated_at;
	}
	public void setGoodsCreated_at(String goodsCreated_at) {
		this.goodsCreated_at = goodsCreated_at;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	
	
	
}
