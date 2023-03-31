package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.fx.market.common.Session;
import com.fx.market.dao.ItemDao;
import com.fx.market.dto.ItemDto;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;

public class ItemController implements Initializable {

	@FXML ImageView photo;
	@FXML Circle profilePhoto;
	@FXML Label username;
	@FXML Label address;
	@FXML Label temperature;
	@FXML Label itemName;
	@FXML Label date;
	@FXML Label context;
	@FXML Label viewAndLike;
	@FXML Button close;
	@FXML Label title;
	@FXML Label recommandButton;
	@FXML Label price;
	@FXML Button submitButton;
	
	ItemDto item;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// itemDao부르고, 해당 데이터를 item Dto에 넣는다.
		Session session = Session.getInstance();
		this.item = (ItemDto) session.getModel();
		
		setItemData();
	}
	
	private void setItemData() {
		// DTO에들어있는 데이터를 라벨에 넣는다.
		itemName.setText(item.getItemName());
		context.setText(item.getItemContext());
	}

	public void onCancelButtonClick() {
		
	}
	
	
	
}
