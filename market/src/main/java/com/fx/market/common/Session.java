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
    private String accountId;
    private String name;
    private int loginChk;
    private Stage stage;

    public String getAccountId() {
        return accountId;
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

    private Session() {
    }

    public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }
}
