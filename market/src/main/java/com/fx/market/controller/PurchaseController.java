	package com.fx.market.controller;

import com.fx.market.dao.PurchaseDao;
import com.fx.market.dto.ItemDto;
import com.fx.market.repository.MemoryRepository;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PurchaseController {

	@FXML private Label testTitle;
	@FXML private TextField title;
	@FXML private TextField price;
	@FXML private TextField context;
	@FXML private TextField local;
	@FXML private Button submit;
	
	
	//MemoryRepository repository = new MemoryRepository();
	PurchaseDao goodsDao = new PurchaseDao();
	int seq;
	
	@FXML
	protected String saveItemData() {
		ItemDto dto = new ItemDto();
		
		// item의 id == goods_id (DB)에서 예시 : g1
		// g를 붙이기 위해서 문자열 처리가 필요
		dto.setItemId(makeItemId(seq++));
		dto.setItemName(title.getText());
		dto.setItemPrice(Long.valueOf(price.getText()));
		dto.setItemLocal(local.getText());
		dto.setItemContext(context.getText());
		goodsDao.saveItem(dto);
		System.out.println(dto.getItemName() + "이 저장되었습니다.");
		return dto.getItemName();
	}
	
	
	 @FXML
	    protected void onSubmitButtonClick() {
		 
		 	String saveItemId = saveItemData();
		 	
		 	Alert alert = new Alert(AlertType.WARNING);
		 	alert.setTitle("거래 완료 창");
		 	alert.setHeaderText("거래가 완료되었습니다.");
		 	alert.setContentText(saveItemId + " 거래가 완료되었다고!!");
		 	alert.showAndWait();
	    }
	 
	 	private String makeItemId(int seq) {
	 		return "g".concat(String.valueOf(seq));
	 	}
}

