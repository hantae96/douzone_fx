	package com.fx.market.controller;

import com.fx.market.service.RegisterService;

import javafx.fxml.FXML;

public class RegisterController {

	RegisterService registerService = new RegisterService();
	
	@FXML
	private void onSubmitButtonClick() {
		registerService.saveItem();
	}
}

