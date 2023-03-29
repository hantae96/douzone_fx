package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.service.LoginService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable{
	@FXML TextField id;
	@FXML PasswordField pw;
	private LoginService service;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		service = new LoginService();
	}
		
	public void buttonLoginMethod() {
		service.buttonLoginMethod(id.getText(),pw.getText());
	}
}
