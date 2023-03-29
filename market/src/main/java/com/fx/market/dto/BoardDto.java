package com.fx.market.dto;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BoardDto {
	
	

	/* boards 테이블 */
	private String boardId;			//게시글 ID
	private String accountId;		//계정 ID
	private String mainCategory;	//게시글 카테고리 대분류
	private String middleCategory;	//게시글 카테고리 중분류
	private String title;			//게시글 제목
	private String content;			//게시글 내용
	private int recomends;			//게시글 추천수
	private int views;				//게시글 조회수
	private String address;			//게시글 주소
	private Date createdAt;			//게시글 생성일시
	
	/* meetings 테이블 */
	private int person;				//만남 인원수
	private String meetingDate;		//만남 일자
	private String meetingTime;		//만남 시간
	private String place;			//만남 장소
	private String gender;			//만남 성별
	private String age;				//만남 나이연령
	
	
	
	
	public BoardDto(String boardId, String accountId, String mainCategory, String middleCategory, String title,
			String content, String person, String meetingDate, String meetingTime, String place, String gender, String age) {
		this.boardId = boardId;
		this.accountId = accountId;
		this.mainCategory = mainCategory;
		this.middleCategory = middleCategory;
		this.title = title;
		this.content = content;
		this.person = Integer.valueOf(person);
		this.meetingDate = meetingDate;
		this.meetingTime = meetingTime;
		this.place = place;
		this.gender = gender;
		this.age = age;
	}



	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getMainCategory() {
		return mainCategory;
	}
	public void setMainCategory(String mainCategory) {
		this.mainCategory = mainCategory;
	}
	public String getMiddleCategory() {
		return middleCategory;
	}
	public void setMiddleCategory(String middleCategory) {
		this.middleCategory = middleCategory;
	}
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
	public int getRecomends() {
		return recomends;
	}
	public void setRecomends(int recomends) {
		this.recomends = recomends;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
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
	public int getPerson() {
		return person;
	}
	public void setPerson(int person) {
		this.person = person;
	}
	public Date getMeetingDate() {
		return meetingDate;
	}
	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}
	public Time getMeetingTime() {
		return meetingTime;
	}
	public void setMeetingTime(Time meetingTime) {
		this.meetingTime = meetingTime;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
}


//
//CREATE TABLE boards (
//		  boards_id VARCHAR2(25),
//		  accounts_id VARCHAR2(20),
//		  main_category VARCHAR2(20),
//		  middle_category VARCHAR2(20),
//		  title VARCHAR2(50),
//		  content VARCHAR2(200),
//		  recommends NUMBER(5),
//		  views NUMBER(5),
//		  address VARCHAR2(200),
//		  created_at DATE,
//		  PRIMARY KEY (boards_id)
//		);
//
//
//		CREATE TABLE meetings (
//		  boards_id VARCHAR2(25),
//		  person NUMBER(2),
//		  meeting_date VARCHAR2(50),
//		  meeting_time VARCHAR2(50),
//		  place VARCHAR2(50),
//		  gender VARCHAR2(10),
//		  age NUMBER(2),
//		  PRIMARY KEY (boards_id)
//		);