package com.example.fxproject.sample.fxSceneBuilder.ex2;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Ex2Controller implements Initializable{
	// 어노테이션
	@FXML TextField idField;
	@FXML PasswordField pwField;
	@FXML Button loginButton;
	
//	private Parent form;
//	
//	public void setForm(Parent form) {
//		this.form = form;
//	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		System.out.println("form : " + form);
//		TextField idField = (TextField)form.lookup("#idField");
//		PasswordField pwField = (PasswordField) form.lookup("#pwField");
//		Button loginButton = (Button)form.lookup("#loginButton");
		
		loginButton.setOnMouseClicked(e->{
			loginButtonMethod();
		});
	}
	
	public void loginButtonMethod() {
		System.out.println("아이디 : " + idField.getText());
		System.out.println("비밀번호 : " + pwField.getText());
	}

}









