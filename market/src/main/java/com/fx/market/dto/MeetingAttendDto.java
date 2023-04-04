package com.fx.market.dto;

public class MeetingAttendDto {

	private String meetingId;
	private String accountId;
	public MeetingAttendDto(String meetingId, String accountId) {
		this.meetingId = meetingId;
		this.accountId = accountId;
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
