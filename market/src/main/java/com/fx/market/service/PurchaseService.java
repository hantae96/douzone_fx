package com.fx.market.service;

import com.fx.market.dao.PurchaseDao;
import com.fx.market.dto.ItemDto;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PurchaseService {
	PurchaseDao goodsDao = new PurchaseDao();
	int seq;

	@FXML private Label testTitle;
	@FXML private TextField title;
	@FXML private TextField price;
	@FXML private TextField context;
	@FXML private TextField local;

	
	
	
    public void saveItem() {	 
	 	Alert alert = new Alert(AlertType.WARNING);
	 	alert.setTitle("거래 완료 창");
	 	alert.setHeaderText("거래가 완료되었습니다.");
	 	alert.showAndWait();
    }
    
    @FXML	
    protected void saveItemData() {
		// item의 id == goods_id (DB)에서 예시 : g1
		// g를 붙이기 위해서 문자열 처리가 필요
		goodsDao.saveItem(new ItemDto(makeItemId(seq++), 
										title.getText(), 
										Long.valueOf(price.getText()), 
										local.getText(),
										context.getText()));
	}
	
 
 	private String makeItemId(int seq) {
 		return "g".concat(String.valueOf(seq));
 	}
}
