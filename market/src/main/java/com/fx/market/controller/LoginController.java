package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable{
	@FXML TextField id;
	@FXML PasswordField pw;
	@FXML Button button;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		id.textProperty().addListener((a, before, after) -> {
	//
//			String result = idLengthCheck(after);
//			id.setText(result);
//		});
	}
		
	public void buttonLoginMethod() {
		System.out.println("아이디: "+id.getText()); 
		System.out.println("비밀번호: "+pw.getText());
		
		String dbId ="admin";
		String dbPw ="1234";
		
		if(id.getText().isBlank() || pw.getText().isBlank()) {
			System.out.println("아이디 또는 비밀번호를 입력해주세요");
		}else if(id.getText().equals(dbId) && pw.getText().equals(dbPw)) {
			System.out.println("축하합니다 인증성공!!");
		}else {
			System.out.println("인증실패!! 아이디 또는 비밀번호를 확인해주세요");
		}
		}

	//public String idLengthCheck(String userId) {
//		// 최대 길이 10자리
//		if(userId.length() > 10) {
//			return userId.substring(0, 10);
//		}
//		return userId;
	//}
}
