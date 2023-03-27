package com.example.fxproject.sample.fxSceneBuilder.ex2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Ex3Controller implements Initializable{
	// 어노테이션
	@FXML TextField idField;
	@FXML PasswordField pwField;
	@FXML Button loginButton;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {}
	
	// 로그인 버튼이 클릭되면 동작함.
	public void loginButtonMethod() {
		System.out.println("아이디 : " + idField.getText());
		System.out.println("비밀번호 : " + pwField.getText());
	}
	
}





