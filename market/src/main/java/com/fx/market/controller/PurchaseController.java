	package com.fx.market.controller;

import com.fx.market.service.PurchaseService;

import javafx.fxml.FXML;

public class PurchaseController {

	PurchaseService purchaseService = new PurchaseService();
	
	@FXML
	//MemoryRepository repository = new MemoryRepository();
	private void onSubmitButtonClick() {
		purchaseService.saveItem();
	}
	
	
	
	
	
	 
}

