package com.fx.market.controller;
import com.fx.market.service.HomeService;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class HomeController {

	HomeService homeService = new HomeService();

	// 홈화면 실행하는 거 하는중..
	public void setViewHome(Stage stage) {
		homeService.view(stage);
	}

	public void viewHome(Stage stage) {

	}

	@FXML
	private void purchaseNavClick(Event event) {

	}

	@FXML
	private void boardNavClick(Event event) {

	}

	@FXML
	private void aroundNavClick(Event event) {

	}

	@FXML
	private void accountNavClick(Event event) {

	}

}
