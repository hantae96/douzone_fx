package com.fx.market.controller;

import java.net.URL;
import java.util.ResourceBundle;
import com.fx.market.common.Session;
import com.fx.market.common.Util;
import com.fx.market.common.Viewer;
import com.fx.market.dto.ItemDto;
import com.fx.market.dto.ItemUserDto;
import com.fx.market.service.ItemService;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class ItemController implements Initializable {

	@FXML
	ImageView photo;
	@FXML
	Circle profilePhoto;
	@FXML
	Label username;
	@FXML
	Label address;
	@FXML
	Label temperature;
	@FXML
	Label itemName;
	@FXML
	Label date;
	@FXML
	Label context;
	@FXML
	Label viewAndLike;
	@FXML
	Button close;
	@FXML
	Label title;
	@FXML
	Label recommandButton;
	@FXML
	Label price;
	@FXML
	Button submitButton;

	ItemDto item;
	ItemService itemService;
	ItemUserDto user;
	Session session;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// itemDao부르고, 해당 데이터를 item Dto에 넣는다.
		this.session = Session.getInstance();
		this.item = (ItemDto) session.getModel();
		this.itemService = new ItemService();
		this.user = itemService.getUserById(item.getItemId());
		checkLikeButton();
		setItemData();
		setUserData();
	}

	private void setItemData() {
		// DTO에들어있는 데이터를 라벨에 넣는다.
		itemName.setText(item.getItemName());
		context.setText(item.getItemContext());
		date.setText(item.getDate());
		price.setText(Util.priceAddComma(item.getItemPrice()).concat(" 원"));
		viewAndLike.setText("조회수 "
				.concat(String.valueOf(item.getView()).concat(" · 추천수 ").concat(String.valueOf(item.getRecommend()))));
	}

	private void setUserData() {
		username.setText(user.getUserName());
		address.setText(user.getAddress());
		temperature.setText(user.getTemperature().concat(" ℃"));
	}

	public void onCancelButtonClick() {
		Viewer viewer = new Viewer();
		viewer.setView("home");
	}

	public void checkLikeButton() {
		String accountId = session.getAccountId();
		if (itemService.checkLike(accountId, item.getItemId())) {
			recommandButton.setText("♥");
		} else {
			recommandButton.setText("♡");
		}
	}

	public void LikeButtonClicked() {
		String accountId = session.getAccountId();
		// 해당 물품에 좋아요 버튼을 누르지 않앗으면 favorites 에 좋아요 정보를 업데이트하고 채운하트로 바꾼다.
		// 해당 물품에 좋아요 버튼을 누른 데이터가 있으면 채운하트로 출력한다. -> 다시 버튼을 누르면 하트를 빈하트로 바꾸고 좋아요 테이블에서
		// 데이터를 지운다.
		if (itemService.clickLike(accountId, item.getItemId())) {
			recommandButton.setText("♡");
		} else {
			recommandButton.setText("♥");

		}
	}
}
