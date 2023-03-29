package com.fx.market.service;

import com.fx.market.dao.LoginDao;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class LoginService {
	private LoginDao dao;
	
	public LoginService() {
	dao = new LoginDao();
}
	public void buttonLoginMethod(String id, String pw) {
		
		if(id.isEmpty() || pw.isEmpty()) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText("알림");
			alert.setContentText("아이디 또는 비밀번호를 입력하세요.");
			alert.show();
			return;}
		
		String dbPw = dao.idCheck(id);
		
		if(dbPw == null || dbPw.isEmpty()) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("알림");
			alert.setContentText("로그인 실패");
			alert.show();
			return;}
	
		if(dbPw.equals(pw)) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setHeaderText("알림");
			alert.setContentText("로그인 성공");
			alert.show();
			
		}else {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("알림");
			alert.setContentText("로그인 실패");
			alert.show();
	}
}
}
