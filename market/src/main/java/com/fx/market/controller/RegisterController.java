	package com.fx.market.controller;

import com.fx.market.dto.ItemDto;
import com.fx.market.service.RegisterService;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class RegisterController {
	
	@FXML private Label testTitle;
	@FXML private TextField title;
	@FXML private TextField price;
	@FXML private TextField context;
	@FXML private TextField local;

	RegisterService registerService = new RegisterService();
	
	@FXML
	private void onRegsistButtonClick() {
		registerService.saveItemData(new ItemDto( 
				title.getText(), 
				Long.valueOf(price.getText()), 
				local.getText(),
				context.getText()));
		
	}
	

    public void alertItem() {	 
    	System.out.println("??");
	 	Alert alert = new Alert(AlertType.WARNING);
	 	alert.setTitle("거래 완료 창");
	 	alert.setHeaderText("거래가 완료되었습니다.");
	 	alert.showAndWait();
    }
 
	
}

