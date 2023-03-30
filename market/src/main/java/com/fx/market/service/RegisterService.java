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


	public void saveItemData(ItemDto itemDto) {
    	System.out.println("!!");
    	
		goodsDao.saveItem(itemDto);
	}
}
