package com.fx.market.service;

import com.fx.market.dao.RegisterDao;
import com.fx.market.dto.ItemDto;
import com.fx.market.dto.PhotoDto;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class RegisterService {
	RegisterDao registerDao;
	public RegisterService(RegisterDao registerDao) {
		this.registerDao = registerDao;
	}


    public String saveItemData(ItemDto itemDto) {
        RegisterDao registerDao = new RegisterDao();
    	String itemId=registerDao.saveItem(itemDto);
        alert(itemDto.getItemName());
        return itemId;
    }
    
    public void alert(String itemName) {	 
	 	Alert alert = new Alert(AlertType.WARNING);
	 	alert.setTitle("등록 완료 창");
	 	alert.setHeaderText(itemName + " 등록이 완료되었습니다.");
	 	alert.showAndWait();
    }

	public void photosInsert(PhotoDto photoDto) {
		registerDao.savePhoto(photoDto);
	}


	public String getItemId() {
		registerDao.getId();
		return null;
	}
}
