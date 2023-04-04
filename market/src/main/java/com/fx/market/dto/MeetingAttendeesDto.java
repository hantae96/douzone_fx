package com.fx.market.dto;

public class MeetingAttendeesDto {

	private String meetingId;
	private String accountId;
	private String name;
	private String address;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	private String path;
	
	public MeetingAttendeesDto(String meetingId, String accountId) {
		this.meetingId = meetingId;
		this.accountId = accountId;
	}
	public MeetingAttendeesDto() {
		
	}
	public String getMeetingId() {
		return meetingId;
	}
	public void setMeetingId(String meetingId) {
		this.meetingId = meetingId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	
	
}
