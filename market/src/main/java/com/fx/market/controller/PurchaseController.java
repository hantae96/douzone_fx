package com.fx.market.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PurchaseController {

	@FXML private Label testTitle;
	@FXML private TextField price;
	@FXML private TextField context;
	@FXML private TextField local;
	@FXML private Button submit;
	
	
	 @FXML
	    protected void onSubmitButtonClick() {
		 	Alert alert = new Alert(AlertType.WARNING);
		 	alert.setTitle("거래 완료 창");
		 	alert.setHeaderText("거래가 완료되었습니다.");
		 	alert.setContentText("거래가 완료되었다고!!");
		 	
		 	alert.showAndWait();
	    }
}