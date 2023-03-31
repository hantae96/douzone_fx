package com.fx.market.service;

import com.fx.market.common.Session;
import com.fx.market.dao.LoginDao;
import com.fx.market.dto.LoginDto;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class LoginService {
	private LoginDao dao;
	
	public LoginService() {
	dao = new LoginDao();
}
	public int buttonLoginMethod(String id, String pw) {

		if(id.isEmpty() || pw.isEmpty()) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("알림");
			alert.setContentText("아이디 또는 비밀번호를 입력하세요.");
			alert.show();
			return 0;
			}
		
		LoginDto dbUser = dao.idCheck(id, pw);
		
		if(dbUser == null || dbUser.equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("알림");
			alert.setContentText("로그인 실패");
			alert.show();
			return 0;
			}else{  //로그인 성공 시
			
			Session session = Session.getInstance();
			
			session.setLoginChk(1);
			session.setAccountId(dbUser.getAccounts_id());
			session.setAddress(dbUser.getAddress());
			
			return 1;
			
		}

}
	
}

