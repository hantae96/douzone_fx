package com.fx.market.dto;

public class MeetingAttendeesDto {

	private String boardId;
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
	
	public MeetingAttendeesDto(String boardId, String accountId) {
		this.boardId = boardId;
		this.accountId = accountId;
	}
	public MeetingAttendeesDto() {
		
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
	
	
}
