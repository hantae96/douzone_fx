package com.fx.market.dto;

import java.sql.Date;

public class FreeBoardDto {
	private String title; 					// 제목
	private String content;					// 내용
	private String main_category; 			// 대분류
	private String middle_category; 		// 중분류
	private String board_Id; 				// 게시글 Id
	private String acount_Id;				// 작성자 Id
	private int views; 						// 조회수
	private int recomends;					// 추천수
	private String address; 				// 작성자 주소
	private Date createdAt;					// 작성날짜
	
	
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMain_category() {
		return main_category;
	}
	public void setMain_category(String main_category) {
		this.main_category = main_category;
	}
	public String getMiddle_category() {
		return middle_category;
	}
	public void setMiddle_category(String middle_category) {
		this.middle_category = middle_category;
	}
	public String getBoard_Id() {
		return board_Id;
	}
	public void setBoard_Id(String board_Id) {
		this.board_Id = board_Id;
	}
	public String getAcount_Id() {
		return acount_Id;
	}
	public void setAcount_Id(String acount_Id) {
		this.acount_Id = acount_Id;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getRecomends() {
		return recomends;
	}
	public void setRecomends(int recomends) {
		this.recomends = recomends;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
	
}
