package com.example.fxproject.sample.fxSceneBuilder.ex2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Ex4Controller implements Initializable{
	// 어노테이션
	@FXML TextField idField;
	@FXML PasswordField pwField;
	@FXML Button loginButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		System.out.println(idField.textProperty());
		idField.textProperty().addListener((a, before, after) -> {
//			System.out.println("before : " + before);
//			System.out.println("after : " + after);
			String result = idLengthCheck(after);
			idField.setText(result);
		});
	
		pwField.textProperty().addListener((a, before, after) -> {
			if(after.length() > 10) {
				pwField.setText(before);
			}
		});
	}
	
	public String idLengthCheck(String userId) {
		// 최대 길이 10자리
		if(userId.length() > 10) {
			return userId.substring(0, 10);
		}
		return userId;
	}
	
	public void message(String contentText) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText("알림");
		alert.setContentText(contentText);
		alert.show();
	}
	
	// 로그인 버튼이 클릭되면 동작함.
	public void loginButtonMethod() {
		String dbId = "admin";
		String dbPw = "1234";
		
		String userId = idField.getText();
		String userPw = pwField.getText();
		
		if(userId.isEmpty()) {
			message("아이디를 입력하세요.");
		}else if(userPw.isEmpty()) {
			message("비밀번호를 입력하세요.");
		}else if(dbId.equals(userId) && dbPw.equals(userPw) ) {
			message("로그인 성공");
		}else {
			message("로그인 실패");
		}
		
	}
	
}





