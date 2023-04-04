package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.common.Viewer;
import com.fx.market.service.LoginService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class e_nameCheckController implements Initializable{
	@FXML TextField name;
	@FXML TextField email;
	
	private LoginService service;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		service = new LoginService();
		
	}

	public void e_nameMethod() {
		
		int Check = service.e_nameMethod(name.getText(),email.getText());
		
		if(Check == 1) {
		Viewer viewer = new Viewer();
		viewer.setView("idConfirm");
		}
}
	public void e_nameCancel() {
		Viewer viewer = new Viewer();
		viewer.setView("login");
	}
}
