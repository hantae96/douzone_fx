package com.fx.market.dto;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BoardDto {

	/* boards 테이블 */
	private String boardId;			//게시글 ID
	private String accountId;		//계정 ID
	private String mainCategory;	//게시글 카테고리 대분류
	private String subCategory;		//게시글 카테고리 중분류
	private String title;			//게시글 제목
	private String content;			//게시글 내용
	private int recommends;			//게시글 추천수
	private int views;				//게시글 조회수
	private String address;			//게시글 주소
	private Date createdAt;			//게시글 생성일시
	
	/* meetings 테이블 */
	private String state;
	private String person;				//만남 인원수
	private Date meetingDate;			//만남 일자
	private String meetingTimeAmpm;		//만남 AM/PM
	private String meetingTimeHour;		//만남 시
	private String meetingTimeMinute;	//만남 분
	private String place;				//만남 장소
	private String gender;				//만남 성별
	private String age;					//만남 나이연령
	
	public BoardDto() {	}
	
	public BoardDto(String accountId, String mainCategory, String subCategory, String title,
			String content, String address,String person, LocalDate meetingDate, String meetingTimeAmpm, String meetingTimeHour, String meetingTimeMinute, String place, String gender, String age) {	
		this.accountId = accountId;
		this.mainCategory = mainCategory;
		this.subCategory = subCategory;
		this.title = title;
		this.content = content;
		this.address = address;
		this.person = person;
		this.meetingDate = Date.valueOf(meetingDate);
		this.meetingTimeAmpm = meetingTimeAmpm;
		this.meetingTimeHour = meetingTimeHour;
		this.meetingTimeMinute = meetingTimeMinute;
		this.place = place;
		this.gender = gender;
		this.age = age;
	}

	public BoardDto(String boardId, String accountId, String mainCategory, String subCategory, String title,
			String content, String address,String person, LocalDate meetingDate, String meetingTimeAmpm, String meetingTimeHour, String meetingTimeMinute, String place, String gender, String age) {	
	
		this.boardId = boardId;
		this.accountId = accountId;
		this.mainCategory = mainCategory;
		this.subCategory = subCategory;
		this.title = title;
		this.content = content;
		this.address = address;
		this.person = person;
		this.meetingDate = Date.valueOf(meetingDate);
		this.meetingTimeAmpm = meetingTimeAmpm;
		this.meetingTimeHour = meetingTimeHour;
		this.meetingTimeMinute = meetingTimeMinute;
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

	public String getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
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

	public int getRecommends() {
		return recommends;
	}

	public void setRecommends(int recommends) {
		this.recommends = recommends;
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

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public Date getMeetingDate() {
		return meetingDate;
	}

	public void setMeetingDate(Date meetingDate) {
		this.meetingDate = meetingDate;
	}

	public String getMeetingTimeAmpm() {
		return meetingTimeAmpm;
	}

	public void setMeetingTimeAmpm(String meetingTimeAmpm) {
		this.meetingTimeAmpm = meetingTimeAmpm;
	}

	public String getMeetingTimeHour() {
		return meetingTimeHour;
	}

	public void setMeetingTimeHour(String meetingTimeHour) {
		this.meetingTimeHour = meetingTimeHour;
	}

	public String getMeetingTimeMinute() {
		return meetingTimeMinute;
	}

	public void setMeetingTimeMinute(String meetingTimeMinute) {
		this.meetingTimeMinute = meetingTimeMinute;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public String getMeetingTime() {
		return meetingTimeAmpm+" "+meetingTimeHour+" "+meetingTimeMinute;
	}
	
	public String getMeetingDateFormat() {
		
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(meetingDate).substring(0, 10);
	}
	
	public LocalDate getMeetingDateToLocalDate() {
        
        return LocalDate.parse(getMeetingDateFormat(), DateTimeFormatter.ISO_DATE);
	}
	

}



///* boards 시퀀시 */
//CREATE SEQUENCE boards_seq START WITH 8;
//
///* boards 테이블 */
//CREATE TABLE boards (
//  boards_id VARCHAR2(25),
//  accounts_id VARCHAR2(20),
//  main_category VARCHAR2(20),
//  sub_category VARCHAR2(20),
//  title VARCHAR2(50),
//  content VARCHAR2(200),
//  address VARCHAR2(50),
//  recommends NUMBER(5) default 0,
//  views NUMBER(5) default 0,
//  created_at DATE default sysdate,
//  PRIMARY KEY (boards_id)
//);
//
//
//
//
//
//insert into boards (boards_id, accounts_id, main_category, sub_category, title, content, address)
//values('b1', 'test', '함께해요', '산책', '산책 같이해요', '한강 산책하실분?', '서울시 종로구');
//insert into boards (boards_id, accounts_id, main_category, sub_category, title, content, address)
//values('b2', 'test', '함께해요', '산책', '산책 같이해요', '한강 산책하실분?', '서울시 종로구');
//insert into boards (boards_id, accounts_id, main_category, sub_category, title, content, address)
//values('b3', 'test', '함께해요', '산책', '산책 같이해요', '한강 산책하실분?', '서울시 종로구');
//insert into boards (boards_id, accounts_id, main_category, sub_category, title, content, address)
//values('b4', 'test', '함께해요', '산책', '산책 같이해요', '한강 산책하실분?', '서울시 종로구');
//insert into boards (boards_id, accounts_id, main_category, sub_category, title, content, address)
//values('b5', 'test', '함께해요', '산책', '산책 같이해요', '한강 산책하실분?', '서울시 종로구');
//insert into boards (boards_id, accounts_id, main_category, sub_category, title, content, address)
//values('b6', 'test', '함께해요', '산책', '산책 같이해요', '한강 산책하실분?', '서울시 종로구');
//insert into boards (boards_id, accounts_id, main_category, sub_category, title, content, address)
//values('b7', 'test', '함께해요', '산책', '산책 같이해요', '한강 산책하실분?', '서울시 종로구');
//
//
///*  테이블 */
//CREATE TABLE meetings (
//  boards_id VARCHAR2(25),
//  person VARCHAR2(10),
//  meeting_date Date,
//  meeting_time_ampm VARCHAR2(6),
//  meeting_time_hour VARCHAR2(6),
//  meeting_time_minute VARCHAR2(6),
//  place VARCHAR2(50),
//  gender VARCHAR2(10),
//  age VARCHAR2(10),
//  PRIMARY KEY (boards_id)
//);
//
//insert into meetings (boards_id, person, meeting_date, meeting_time_ampm, meeting_time_hour, meeting_time_minute, place, gender, age)
//values('b1', 4, '2021-11-12','오전', '11시', '30분', '한강', '여자만', '20대');
//insert into meetings (boards_id, person, meeting_date, meeting_time_ampm, meeting_time_hour, meeting_time_minute, place, gender, age)
//values('b2', 4, '2021-11-12','오전', '11시', '30분', '한강', '여자만', '20대');
//insert into meetings (boards_id, person, meeting_date, meeting_time_ampm, meeting_time_hour, meeting_time_minute, place, gender, age)
//values('b3', 4, '2021-11-12','오전', '11시', '30분', '한강', '여자만', '20대');
//insert into meetings (boards_id, person, meeting_date, meeting_time_ampm, meeting_time_hour, meeting_time_minute, place, gender, age)
//values('b4', 4, '2021-11-12','오전', '11시', '30분', '한강', '여자만', '20대');
//insert into meetings (boards_id, person, meeting_date, meeting_time_ampm, meeting_time_hour, meeting_time_minute, place, gender, age)
//values('b5', 4, '2021-11-12','오전', '11시', '30분', '한강', '여자만', '20대');
//
//
//ALTER TABLE meetings ADD CONSTRAINT fk_meetings_boards_id
//FOREIGN KEY (boards_id) REFERENCES boards(boards_id);
//
//ALTER TABLE meetings DROP CONSTRAINT fk_meetings_boards_id;