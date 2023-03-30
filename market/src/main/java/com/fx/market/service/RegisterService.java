package com.fx.market.service;

import com.fx.market.dao.RegisterDao;
import com.fx.market.dto.ItemDto;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RegisterService {
	RegisterDao goodsDao = new RegisterDao();

	@FXML private Label testTitle;
	@FXML private TextField title;
	@FXML private TextField price;
	@FXML private TextField context;
	@FXML private TextField local;

    public void alertItem() {	 
    	System.out.println("??");
	 	Alert alert = new Alert(AlertType.WARNING);
	 	alert.setTitle("거래 완료 창");
	 	alert.setHeaderText("거래가 완료되었습니다.");
	 	alert.showAndWait();
    }
    
    @FXML
	public void saveItemData() {
    	System.out.println("!!");

		goodsDao.saveItem(new ItemDto( 
										title.getText(), 
										Long.valueOf(price.getText()), 
										local.getText(),
										context.getText()));
	}
}
