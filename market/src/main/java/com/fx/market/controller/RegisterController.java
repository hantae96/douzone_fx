package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.dao.RegisterDao;
import com.fx.market.dto.ItemDto;
import com.fx.market.service.RegisterService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class RegisterController implements Initializable {
	RegisterService registerService;

	@FXML
	private TextField name;

	@FXML
	private TextField price;

	@FXML
	private TextField context;

	@FXML
	private TextField address;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.registerService = new RegisterService(new RegisterDao());
	}

	@FXML
	private void onRegsistButtonClick() {
		registerService.saveItemData(
				new ItemDto(name.getText(), Long.valueOf(price.getText()), context.getText(), address.getText()));
	}
	

    public void alertItem() {	 
    	System.out.println("??");
	 	Alert alert = new Alert(AlertType.WARNING);
	 	alert.setTitle("거래 완료 창");
	 	alert.setHeaderText("거래가 완료되었습니다.");
	 	alert.showAndWait();
    }
 
	
}
