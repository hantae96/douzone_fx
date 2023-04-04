package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.common.Viewer;
import com.fx.market.service.LoginService;
import com.fx.market.service.UpdateAccountService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class IdCheckController implements Initializable{
	@FXML TextField id;
	
	private LoginService service;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		service = new LoginService();
		
	}

	public void userPwMethod() {
		int pwCheck = service.userPwMethod(id.getText());
		
		if(pwCheck == 1) {
			
		Viewer viewer = new Viewer();
		viewer.setView("login");
		}
}
}