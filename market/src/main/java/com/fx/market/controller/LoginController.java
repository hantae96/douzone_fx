package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.service.LoginService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable{
	@FXML TextField id;
	@FXML PasswordField pw;
	private LoginService service;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new LoginService();

	}
		
	public void buttonLoginMethod() {
		int result = service.buttonLoginMethod(id.getText(),pw.getText());
		if(result == 1) {
			
		Session session = Session.getInstance();
		Stage stage = session.getStage();
		
		session.setLoginChk(result);
		session.setAccountId(id.getText());
		
		Viewer viewer = new Viewer();
		viewer.setView("home");
		}
	}


	
	public void regClickedMethod() {
		Session session = Session.getInstance();
		Stage stage = session.getStage();
		
		Viewer viewer = new Viewer();
		viewer.setView("signUp");
	}
}
