package com.fx.market.common;

import javafx.stage.Stage;

//Session의 인스턴스를 가져온 후 계정 ID과 이름을 Set한다
//Session session = Session.getInstance();
//session.setAccountId("ragoha");
//session.setName("김태영");
//
//Session의 인스턴스를 가져온 후 계정 ID와 이름을 Get한다
//Session session = Session.getInstance();
//String accountId = session.getAccountId();
//String name = session.getName(); 

public class Session {

	private static Session instance;
	private String accountId;			//계정 ID
	private String name;				//계정 이름(닉네임)
	private String address;				//계정 주소
	private String tempId;				//임시 ID
	private String whereToGo;			//
	
	private String boardId; 			//게시글 ID
	
	public String getWhereToGo() {
		return whereToGo;
	}

	public void setWhereToGo(String whereToGo) {
		this.whereToGo = whereToGo;
	}

	public String getTempId() {
		return tempId;
	}

	public void setTempId(String tempId) {
		this.tempId = tempId;
	}

	public String getAddress() {
		return address;
	}

	public static void setInstance(Session instance) {
		Session.instance = instance;
	}

	private int loginChk;
	private Object model;
	
	public Object getModel() {
		return model;
	}

	public void setModel(Object model) {
		this.model = model;
	}

	private Stage stage;

	public String getAccountId() {
		return accountId;
	}

	public String getaddress() {
		return address;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	private Session() {
	}

	public static Session getInstance() {
		if (instance == null) {
			instance = new Session();
		}
		return instance;
	}

	public int getLoginChk() {
		return loginChk;
	}

	public void setLoginChk(int loginChk) {
		this.loginChk = loginChk;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public String getBoardId() {
		return boardId;
	}

	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}

}
