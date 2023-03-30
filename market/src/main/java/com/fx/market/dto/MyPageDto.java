package com.fx.market.dto;

public class MyPageDto {

	//photo 테이블
	private String photo;		//path
	
	//accounts 테이블
	private String id;			//아이디
	private String name;		//이름
	private String temp;		//매너온도
	private String created_at; 	//생성날짜
	
	//comments 테이블
	private int rating_num;		//받은평가 갯수
	
	//favorites 테이블
	private int favor_num;		//관심상품 갯수
	
	//goods 테이블
	private int sell_num;		//판매상품 갯수
	private int buy_num;		//구매상품 갯수
	
	//boards 테이블
	private int document_num;	//동네생활글 갯수

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public int getRating_num() {
		return rating_num;
	}

	public void setRating_num(int rating_num) {
		this.rating_num = rating_num;
	}

	public int getFavor_num() {
		return favor_num;
	}

	public void setFavor_num(int favor_num) {
		this.favor_num = favor_num;
	}

	public int getSell_num() {
		return sell_num;
	}

	public void setSell_num(int sell_num) {
		this.sell_num = sell_num;
	}

	public int getBuy_num() {
		return buy_num;
	}

	public void setBuy_num(int buy_num) {
		this.buy_num = buy_num;
	}

	public int getDocument_num() {
		return document_num;
	}

	public void setDocument_num(int document_num) {
		this.document_num = document_num;
	}
	
	
	
}
